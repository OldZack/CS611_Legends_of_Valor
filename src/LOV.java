import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LOV extends RPG{

    private Map map;
    private Market market;
    private HeroTeam heroes;
    private MonsterTeam monsters;

    private Scanner input = new Scanner(System.in);
    private Parser p = new Parser();

    @Override
    public void character_selection() throws FileNotFoundException {
        Printer.print_character_select_message();

        ArrayList<Hero> warriors = p.parse_hero("Warriors");
        ArrayList<Hero> sorcerers = p.parse_hero("Sorcerers");
        ArrayList<Hero> paladins = p.parse_hero("Paladins");
        int role_num;
        while (true){
            try {
                role_num = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The input is not a number. Please re-enter:");
                continue;
            }
            if (role_num == 1){
                generate_hero(warriors);
                break;
            }
            else if (role_num == 2){
                generate_hero(sorcerers);
                break;
            }
            else if (role_num == 3){
                generate_hero(paladins);
                break;
            }
            System.out.println("The input number is incorrect. Please re-enter:");
        }

    }

    @Override
    public void startGame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Printer.print_welcome_message();
        this.character_selection();
    }

    @Override
    public void round() throws FileNotFoundException {

    }
}
