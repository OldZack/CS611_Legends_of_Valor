import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LOV extends RPG{

    private Gameboard map;
    private Market market;
    private HeroTeam heroes;
    private MonsterTeam monsters;

    private Scanner input = new Scanner(System.in);
    private Parser p = new Parser();


    LOV() throws FileNotFoundException {
        super();
        market = new Market();
        heroes = new HeroTeam();
        monsters = new MonsterTeam();
        map = new Gameboard(8);
    }

    @Override
    public void character_selection() throws FileNotFoundException {
        ArrayList<Warrior> warriors = p.parse_warrior();
        ArrayList<Sorcerer> sorcerers = p.parse_sorcerer();
        ArrayList<Paladin> paladins = p.parse_paladin();

        String [] order  = {"first", "second", "third"};
        String role_num;
        for (int i = 0; i < 3; i++){
            System.out.println("Please choose the role of your " + order[i] + " hero (by entering the number): ");
            System.out.println("1. Warrior");
            System.out.println("2. Sorcerer");
            System.out.println("3. Paladin");
            while (true){
                role_num = input.nextLine();
                if (Objects.equals(role_num, "1")){
                    generate_hero(warriors);
                    break;
                }
                else if (Objects.equals(role_num, "2")){
                    generate_hero(sorcerers);
                    break;
                }
                else if (Objects.equals(role_num, "3")){
                    generate_hero(paladins);
                    break;
                }
                else if (Objects.equals(role_num, "q")){
                    Printer.quit();
                }
                System.out.println("The input number is incorrect. Please re-enter:");
            }
        }
        System.out.println("\nYou have formed your team! Now it's the time to start your adventure!");
    }

    private void set_hero_positions(){
        for (int i = 0; i < this.heroes.get_hero_team_size(); i++) {
            this.heroes.get_hero(i).position = 70+(3*i);
        }
    }

    private void set_monster_positions(){
        for (int i = 0; i < this.monsters.get_monster_team_size(); i++) {
            this.monsters.get_monster(i).position = (3*i)+1;
        }
    }

    private void generate_hero(ArrayList<? extends Hero> heroes){
        int hero_num;
        for (int j = 0; j < heroes.size(); j++){
            System.out.println(j+1 + ". " + heroes.get(j).get_name());
        }
        System.out.println("Please choose one of the heroes above (by entering the number): ");
        while(true){
            try {
                hero_num = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The input is not a number. Please re-enter:");
                continue;
            }
            if (0 < hero_num && hero_num <= heroes.size()){
                this.heroes.add_heroes(heroes.get(hero_num-1));
                System.out.println("You have recruited "+heroes.get(hero_num-1).get_name()+" to your team!");
                heroes.remove(hero_num-1);
                break;
            }
            System.out.println("The input number does not have a corresponding hero. Please re-enter:");
        }
    }

    private void generate_monsters(){
        this.monsters.add_monster(this.heroes.get_hero(0).level);
        this.monsters.add_monster(this.heroes.get_hero(1).level);
        this.monsters.add_monster(this.heroes.get_hero(2).level);
    }


    @Override
    public void startGame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Printer.PrintWelcomeMsg();
        //Music.play_welcome_music();
        this.character_selection();
        this.set_hero_positions();
        this.generate_monsters();
        this.set_monster_positions();
        Printer.print_LOV_gameboard(map,this.heroes.get_position(),this.monsters.get_position());
        this.round();
    }

    private void update_options(int hero_index){
        // allowed options is a bit map [move_left, move_right, move_up, move_down, attack, teleport, quit]
        int[] allowed_options = this.heroes.get_hero(hero_index).get_allowed_options();
        Integer hero_position = this.heroes.get_hero(hero_index).position;
        int hero_row=(int)hero_position/10;
        int hero_col = (int) hero_position%10;

        List<Integer> monster_positions = new ArrayList<Integer>();
        for (int position:this.monsters.get_position()) {
            monster_positions.add(position);
        }

        if (  hero_col== 0 || hero_col==3 || hero_col==6 ){
            //set move_left to 0
            allowed_options[0]=0;
        }
        if (  hero_col== 1 || hero_col==4 || hero_col==7 ){
            //set move_right to 0
            allowed_options[1]=0;
        }
        if (  hero_row == 7 ){
            //set move_down to 0
            allowed_options[3]=0;
        }
        if (monster_positions.contains(hero_position-1) || monster_positions.contains(hero_position+1)){
            allowed_options[2] = 0;
        }
        if (!monster_positions.contains(hero_position-1) && !monster_positions.contains(hero_position+1) && !monster_positions.contains(hero_position-10) && !monster_positions.contains(hero_position+10) && !monster_positions.contains(hero_position-11) && !monster_positions.contains(hero_position-9) && !monster_positions.contains(hero_position+9) && !monster_positions.contains(hero_position+11)  ){
            allowed_options[4] = 0;
        }

        this.heroes.get_hero(hero_index).set_allowed_options(allowed_options);

    }

    @Override
    public void round() {
        this.hero_round();
        this.monster_round();
        //add check winner
    }


    public void hero_round() {
        for (int i = 0; i < this.heroes.get_hero_team_size(); i++) {

            Hero hero = this.heroes.get_hero(i);
            //print options according to allowed options. Printer.print_options(int hero_index)
            Printer.print_options(this.heroes.get_hero(i));
            while(true) {

                String hero_choice = input.nextLine();
                if (hero_choice.equals("1") && hero.allowed_options[0]==1){
                    hero.position-=1;
                    break;
                }
                if (hero_choice.equals("2") && hero.allowed_options[1]==1){
                    hero.position+=1;
                    break;
                }
                if (hero_choice.equals("3") && hero.allowed_options[2]==1){
                    hero.position-=10;
                    break;
                }
                if (hero_choice.equals("4") && hero.allowed_options[3]==1){
                    hero.position+=10;
                    break;
                }
                else {
                    System.out.println("Not a Valid Input. Try Again!");
                }
            }
            Printer.print_LOV_gameboard(map, this.heroes.get_position(),this.monsters.get_position());
        }
    }

    public void monster_round(){
        // actions taken by each monster in a round.

    }
}
