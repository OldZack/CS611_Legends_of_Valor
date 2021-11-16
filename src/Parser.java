import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private Scanner input;

    Parser(){
    }

    public ArrayList<Hero> parse_warrior() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Warriors.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Hero> heroes = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            heroes.add(new Warrior(input.next().replace("_", " "), 1, Integer.parseInt(input.next()),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next())));
        }
        return heroes;
    }

    public ArrayList<Hero> parse_sorcerer() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Sorcerers.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Hero> heroes = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            heroes.add(new Sorcerer(input.next().replace("_", " "), 1, Integer.parseInt(input.next()),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next())));
        }
        return heroes;
    }

    public ArrayList<Hero> parse_paladin() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Paladins.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Hero> heroes = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            heroes.add(new Paladin(input.next().replace("_", " "), 1, Integer.parseInt(input.next()),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next()),Integer.parseInt(input.next())));
        }
        return heroes;
    }

    public ArrayList<Hero> parse_all_hero() throws FileNotFoundException {
        ArrayList<Hero> heroes = new ArrayList<Hero>();
        heroes.addAll(parse_warrior());
        heroes.addAll(parse_sorcerer());
        heroes.addAll(parse_paladin());
        return heroes;
    }

    public ArrayList<Monster> parse_dragon() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Dragons.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Monster> monsters = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            monsters.add(new Dragon(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }
        return monsters;
    }

    public ArrayList<Monster> parse_exoskeleton() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Exoskeletons.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Monster> monsters = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            monsters.add(new Exoskeleton(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }
        return monsters;
    }

    public ArrayList<Monster> parse_spirit() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Spirits.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Monster> monsters = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            monsters.add(new Spirit(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }
        return monsters;
    }

    public ArrayList<Monster> parse_all_monster() throws FileNotFoundException {
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        monsters.addAll(parse_dragon());
        monsters.addAll(parse_exoskeleton());
        monsters.addAll(parse_spirit());
        return monsters;
    }

    public ArrayList<Armory> parse_armory() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Armory.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Armory> arms = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            arms.add(new Armory(input.next().replace("_", " "),Integer.parseInt(input.next()),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next())));
        }
        return arms;
    }

    public ArrayList<Weaponry> parse_weaponry() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Weaponry.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Weaponry> weapons = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            weapons.add(new Weaponry(input.next().replace("_", " "),Integer.parseInt(input.next()),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next())));
        }
        return weapons;
    }

    public ArrayList<Potion> parse_potion() throws FileNotFoundException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Potions.txt";
        input  = new Scanner(new File(filename));
        ArrayList<Potion> potions = new ArrayList();
        input.nextLine();
        while (input.hasNext()){
            potions.add(new Potion(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), input.next().split("/")));
        }
        return potions;
    }

    public ArrayList<FireSpell> parse_fire_spell() throws FileNotFoundException {

        String filename = System.getProperty("user.dir") + "/src/files/" + "FireSpells.txt";
        input  = new Scanner(new File(filename));
        ArrayList<FireSpell> fire_spells = new ArrayList();
        input.nextLine();
        while (input.hasNext()){

            fire_spells.add( new FireSpell(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }

        return fire_spells;
    }

    public ArrayList<LightningSpell> parse_lightning_spell() throws FileNotFoundException {

        String filename = System.getProperty("user.dir") + "/src/files/" + "LightningSpells.txt";
        input  = new Scanner(new File(filename));
        ArrayList<LightningSpell> lightning_spells = new ArrayList();
        input.nextLine();
        while (input.hasNext()){

            lightning_spells.add( new LightningSpell(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }

        return lightning_spells;
    }

    public ArrayList<IceSpell> parse_ice_spell() throws FileNotFoundException {

        String filename = System.getProperty("user.dir") + "/src/files/" + "IceSpells.txt";
        input  = new Scanner(new File(filename));
        ArrayList<IceSpell> ice_spells = new ArrayList();
        input.nextLine();
        while (input.hasNext()){

            ice_spells.add( new IceSpell(input.next().replace("_", " "),Integer.parseInt(input.next()),
                    Integer.parseInt(input.next()),Integer.parseInt(input.next()), Integer.parseInt(input.next())));
        }

        return ice_spells;
    }

    public ArrayList<Spell> parse_all_spell() throws FileNotFoundException {
        ArrayList<Spell> spells = new ArrayList<Spell>();
        spells.addAll(parse_fire_spell());
        spells.addAll(parse_lightning_spell());
        spells.addAll(parse_ice_spell());
        return spells;
    }
}
