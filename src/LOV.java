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
    private ArrayList<Integer> explored_positions;


    LOV() throws FileNotFoundException {
        super();
        market = new Market();
        heroes = new HeroTeam();
        monsters = new MonsterTeam();
        map = new Gameboard(8);
        explored_positions = new ArrayList<Integer>();
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
        boolean winner_found = false;
        while(!winner_found) {
            winner_found=this.round();
        }
        System.out.println("Do you want to play again? 1.Yes and 2.No");
        String player_choice = input.next();
        while (!player_choice.equals("1") &&!player_choice.equals("2") ){
            System.out.println("Not a valid input! Re-enter.");
            System.out.println("Do you want to play again? 1.Yes and 2.No");
            player_choice = input.next();
        }
        if (player_choice.equals("1")){
            this.startGame();
        }
        else {
            Printer.quit();
        }

    }

    private void update_options(int hero_index) {
        // allowed options is a bit map [move_left, move_right, move_up, move_down, attack, teleport, quit]
        Hero h = this.heroes.get_hero(hero_index);
        int[] allowed_options = h.get_allowed_options();
        Integer hero_position = h.position;
        int hero_row = (int) hero_position / 10;
        int hero_col = (int) hero_position % 10;

        List<Integer> hero_positions = new ArrayList<Integer>();
        List<Integer> monster_positions = new ArrayList<Integer>();
        for (int position : this.monsters.get_position()) {
            monster_positions.add(position);
        }

        for (int position : this.heroes.get_position()) {
            hero_positions.add(position);
        }

        if (hero_col == 0 || hero_col == 3 || hero_col == 6 || hero_positions.contains(hero_position - 1)) {
            //if hero in left column, set move_left to 0
            allowed_options[0] = 0;

        }
        if (hero_col == 1 || hero_col == 4 || hero_col == 7 || hero_positions.contains(hero_position + 1)) {
            //if hero in right column, set move_right to 0
            allowed_options[1] = 0;
        }
        if (hero_row == 7 || hero_positions.contains(hero_position + 10)) {
            //if hero in nexus, set move_down to 0
            allowed_options[3] = 0;
        }
        if (monster_positions.contains(hero_position - 1) || monster_positions.contains(hero_position + 1) || hero_positions.contains(hero_position - 10)) {
            //if monster in same level, set move up to 0
            allowed_options[2] = 0;
        }
        if (!monster_positions.contains(hero_position - 1) && !monster_positions.contains(hero_position + 1) && !monster_positions.contains(hero_position - 10) && !monster_positions.contains(hero_position + 10) && !monster_positions.contains(hero_position - 11) && !monster_positions.contains(hero_position - 9) && !monster_positions.contains(hero_position + 9) && !monster_positions.contains(hero_position + 11)) {
            //if monster not in vicinity, set attack to 0
            allowed_options[4] = 0;

            for (int i = 0; i < this.monsters.get_monster_team_size(); i++) {
                Monster m = monsters.get_monster(i);

                if (m.get_position() == hero_position - 1 || m.get_position() == hero_position + 1) {
                    allowed_options[2] = 0;
                }
                if (!h.detect_enemy(m)) {
                    allowed_options[4] = 0;
                }
            }
            if (can_teleport(hero_index).size() == 0) {
                //if there are no allowed positions, set teleport to 0
                allowed_options[5] = 0;
            }

            h.set_allowed_options(allowed_options);

        }
    }
    @Override
    public boolean round() {
        this.hero_round();
        this.monster_round();
        return this.check_winner();
        //add check winner
    }



    public ArrayList<Integer> can_teleport(int hero_index){
        List<Integer> hero_positions = new ArrayList<Integer>();
        List<Integer> monster_positions = new ArrayList<Integer>();
        for (int position:this.monsters.get_position()) {
            monster_positions.add(position);
        }

        for (int position:this.heroes.get_position()) {
            hero_positions.add(position);
        }
        int my_position = this.heroes.get_position()[hero_index];
        ArrayList<Integer> allowed_positions = new ArrayList<Integer>();
        for (Integer position:explored_positions) {
            if (my_position%10!=position%10 && my_position%10+1!=position%10 && my_position%10+1!=position%10 && !hero_positions.contains(position) && !monster_positions.contains(position) ){
                allowed_positions.add(position);
            }
        }
        return  allowed_positions;
    }

    public void teleport(int hero_index){
        ArrayList<Integer> allowed_positions = can_teleport(hero_index);
        Printer.print_LOV_gameboard_With_Positions(map,allowed_positions);
        System.out.println("Where do you want to teleport? These are the positions you can teleport to.");
        int new_position = input.nextInt();
        while (!allowed_positions.contains((Integer)new_position)){
            System.out.println("Not a valid input! Re-Enter position.");
            new_position=input.nextInt();
        }
        this.heroes.get_hero(hero_index).position=new_position;
        for (int i = 0; i < this.heroes.get_hero_team_size(); i++) {
          this.heroes.get_hero(i).allowed_options[5]=0;
        }
    }


    public void hero_round() {
        for (int i = 0; i < this.heroes.get_hero_team_size(); i++) {
            this.heroes.get_hero(i).allowed_options = new int[]{1, 1, 1, 1, 1, 1, 1};

        }
        for (int i = 0; i < this.heroes.get_hero_team_size(); i++) {
            this.update_options(i);
            Hero hero = this.heroes.get_hero(i);
            //print options according to allowed options. Printer.print_options(int hero_index)
            Printer.print_options(this.heroes.get_hero(i));
            while(true) {

                String hero_choice = input.nextLine();
                if (hero_choice.equals("1") && hero.allowed_options[0]==1){
                    this.explored_positions.add(hero.position);
                    hero.position-=1;
                    break;
                }
                else if (hero_choice.equals("2") && hero.allowed_options[1]==1){
                    this.explored_positions.add(hero.position);
                    hero.position+=1;
                    break;
                }
                else if (hero_choice.equals("3") && hero.allowed_options[2]==1){
                    //moving up
                    this.explored_positions.add(hero.position);
                    if (hero.allowed_options[0]!=1){
                        this.explored_positions.add(hero.position+1);
                    }
                    if (hero.allowed_options[1]!=1){
                        this.explored_positions.add(hero.position-1);
                    }
                    hero.position-=10;

                    break;
                }
                else if (hero_choice.equals("4") && hero.allowed_options[3]==1){
                    //moving down
                    this.explored_positions.remove((Integer) hero.position);
                    hero.position+=10;
                    break;
                }

                else if (hero_choice.equals("6") && hero.allowed_options[5]==1){
                    teleport(i);
                    break;
                }
                else if (hero_choice.equals("5") && hero.allowed_options[4]==1){
                    ArrayList<Monster> attackable = new ArrayList<>();
                    for (int j = 0; j < this.monsters.get_monster_team_size(); j++){
                        if (hero.detect_enemy(monsters.get_monster(j))){
                            attackable.add(monsters.get_monster(j));
                        }
                    }
                    Printer.print_attack_instruction(hero, attackable);
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
        first_loop:
        for (int i = 0; i < this.monsters.get_monster_team_size(); i++) {
            Monster m = monsters.get_monster(i);
            Integer monster_position = m.get_position();
            int monster_row=(int)monster_position/10;
            int monster_col = (int) monster_position%10;

            for (int j = 0; j < this.heroes.get_hero_team_size(); j++) {
                if (m.detect_enemy(heroes.get_hero(j))){
                    System.out.println(m.get_name() + " deals " + heroes.get_hero(j).take_damage(m.get_damage()) + " damage to " +heroes.get_hero(j).get_name());
                    continue first_loop;
                }
            }
            m.position += 10;
            System.out.println(m.get_name() + " moves forward ");
        }
        Printer.print_LOV_gameboard(map, this.heroes.get_position(),this.monsters.get_position());
    }

    public boolean check_winner(){
        List<Integer> hero_positions = new ArrayList<Integer>();
        List<Integer> monster_positions = new ArrayList<Integer>();
        for (int position:this.monsters.get_position()) {
            monster_positions.add(position);
        }

        for (int position:this.heroes.get_position()) {
            hero_positions.add(position);
        }
        for (Integer position: this.heroes.get_position()) {
            if (position/10 == 0 && !monster_positions.contains(position-1) && !monster_positions.contains(position+1)){
                // hero is the winner
                Printer.print_winner(1);
                return true;
            }
        }
        for (Integer position: this.monsters.get_position()) {
            if (position/10==7 && !hero_positions.contains(position -1) && !hero_positions.contains(position+1)){
                Printer.print_winner(0);
                return true;
            }
        }
        return false;
    }
}
