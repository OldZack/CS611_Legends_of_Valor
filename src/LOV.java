import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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

    @Override
    public void startGame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Printer.PrintWelcomeMsg();
        Music.play_welcome_music();
        this.character_selection();
    }

    @Override
    public void round() throws FileNotFoundException {

    }
}
