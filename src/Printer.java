import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class Printer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String RED_BRIGHT = "\033[0;91m";

    private static Scanner input = new Scanner(System.in);

    public Printer(){
    }


    public static void PrintWelcomeMsg(){
        System.out.println(
"          __________________________________________________         \n" +
" ________|             __        __    __           __      |_______ \n" +
" \\       |     \\    / |_   |    /     |  |   /\\/\\  |_       |      / \n" +
"  \\      |      \\/\\/  |__  |__  \\__   |__|  /    \\ |__      |     /  \n" +
"                       to LEGENDS: Heroes & Monsters \n" +
"  /      |__________________________________________________|     \\  \n" +
" /__________)                                           (__________\\ \n"
			   );
    }

    public static void print_character_select_message(){

    }

    public static String padRight(String s, int n) {
	return String.format("%-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
	return String.format("%" + n + "s", s);
    }

    public static void print_LOV_gameboard(Gameboard gameboard){
        System.out.print(" ");  // Offset first line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println();

        for (int i = 0; i < gameboard.N; i++) {
           // System.out.print("|");  // Print board edge before each row.
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + ANSI_RESET+"  ");
                }
            }
           // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ "|" + "    " + "|" + "    " + "|" + ANSI_RESET+"  ");
                }
            }
           // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() +ANSI_RESET+ "  ");
                }
            }
           // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            System.out.println();

        }

        System.out.print(" ");  // Offset last line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println("\n\n");

    }
    public static void print_LOV_gameboard_With_Positions(Gameboard gameboard, ArrayList<Integer> allowed_positions){
        System.out.print(" ");  // Offset first line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println();

        for (int i = 0; i < gameboard.N; i++) {
            // System.out.print("|");  // Print board edge before each row.
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + ANSI_RESET+"  ");
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    if (allowed_positions.contains((Integer) (i*10)+j)) {
                        System.out.print("  " + gameboard.gameboard[i][j].get_color() + "|" + "   " + "\033[1;97m" + i + j + gameboard.gameboard[i][j].get_color() + "    " + "|" + ANSI_RESET + "  ");
                    }
                    else {
                        System.out.print("  " +gameboard.gameboard[i][j].get_color()+ "|" + "    " + "|" + "    " + "|" + ANSI_RESET+"  ");
                    }
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() +ANSI_RESET+ "  ");
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            System.out.println();

        }

        System.out.print(" ");  // Offset last line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println("\n\n");

    }

    public static void print_LOV_gameboard(Gameboard gameboard, int[] hero_positions, int[] monster_positions){
        ArrayList<int[]> heroes = new ArrayList<int[]>();
        for (int i = 0; i < hero_positions.length; i++) {
            heroes.add(new int[]{(int) Math.floorDiv(hero_positions[i],10),(int) hero_positions[i]%10});
        }
        ArrayList<int[]> monsters = new ArrayList<int[]>();
        for (int i = 0; i < monster_positions.length; i++) {
            monsters.add(new int[]{(int) Math.floorDiv(monster_positions[i],10),(int) monster_positions[i]%10});
        }


        System.out.println("..................Current Monsters............");
        for (int i = 0; i < monsters.size(); i++){
            System.out.println("Row "+monsters.get(i)[0] );
            System.out.println("Col "+monsters.get(i)[1] );
        }

        System.out.println("..................Current Heroes..............");
        for (int i = 0; i < heroes.size(); i++){
            System.out.println("Row "+heroes.get(i)[0]);
            System.out.println("Col "+heroes.get(i)[1]);
        }
        System.out.print(" ");  // Offset first line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println();

        for (int i = 0; i < gameboard.N; i++) {
            // System.out.print("|");  // Print board edge before each row.
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + ANSI_RESET+"  ");
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                String h_container="  ";
                String m_container="  ";
                for (int[] value:heroes) {
                    if (value[0]==i && value[1]==j){
                        h_container="H"+(heroes.indexOf(value)+1);
                    }
                }
                for (int[] value:monsters) {
                    if (value[0]==i && value[1]==j){
                        m_container="M"+(monsters.indexOf(value)+1);
                    }
                }

                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ "|" + " "+"\033[1;97m"+h_container+gameboard.gameboard[i][j].get_color()+" " + "|" + " "+"\033[1;97m"+m_container+gameboard.gameboard[i][j].get_color()+" " + "|" + ANSI_RESET+"  ");
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            for (int j = 0; j < gameboard.N; j++) {
                if (gameboard.gameboard[i][j].get_type().equals("Inaccessible")){
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+gameboard.gameboard[i][j].get_symbol()+ANSI_RESET+"  ");
                }
                else {
                    System.out.print("  " +gameboard.gameboard[i][j].get_color()+ gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() + "----" + gameboard.gameboard[i][j].get_symbol() +ANSI_RESET+ "  ");
                }
            }
            // System.out.print("|");  // Print board edge after each row.
            System.out.println();
            System.out.println();

        }

        System.out.print(" ");  // Offset last line of board by single space.
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+------------");
        }
        System.out.print("+");
        System.out.println("\n\n");



    }



    public static void quit(){
	System.out.println(
"   _____                 _ _                \n" +
"  / ____|               | | |               \n" +
" | |  __  ___   ___   __| | |__  _   _  ___ \n" +
" | | |_ |/ _ \\ / _ \\ / _` | '_ \\| | | |/ _ \\\n" +
" | |__| | (_) | (_) | (_| | |_) | |_| |  __/\n" +
"  \\_____|\\___/ \\___/ \\__,_|_.__/ \\__, |\\___|\n" +
"                                  __/ |     \n" +
"                                 |___/      "
			   );
	System.exit(0);
    }

    public static void print_options(Hero hero, int i){
        // allowed options is a bit map [move_left, move_right, move_up, move_down, attack, teleport, quit]
        System.out.println("What do you want to do "+hero.get_name()+" (H"+(i+1)+")"+" ?");
        if(hero.allowed_options[0]==1){
            System.out.println(GREEN_BRIGHT+"1. Move Left "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"1. Move Left"+ANSI_RESET);
        }

        if(hero.allowed_options[1]==1){
            System.out.println(GREEN_BRIGHT+"2. Move Right "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"2. Move Right"+ANSI_RESET);
        }

        if(hero.allowed_options[2]==1){
            System.out.println(GREEN_BRIGHT+"3. Move Up "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"3. Move Up"+ANSI_RESET);
        }

        if(hero.allowed_options[3]==1){
            System.out.println(GREEN_BRIGHT+"4. Move Down "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"4. Move Down"+ANSI_RESET);
        }

        if(hero.allowed_options[4]==1){
            System.out.println(GREEN_BRIGHT+"5. Attack "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"5. Attack"+ANSI_RESET);
        }

        if(hero.allowed_options[5]==1){
            System.out.println(GREEN_BRIGHT+"6. Teleport "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"6. Teleport"+ANSI_RESET);
        }

        if(hero.allowed_options[6]==1){
            System.out.println(GREEN_BRIGHT+"7. Quit "+ANSI_RESET);
        }
        else {
            System.out.println(RED_BRIGHT+"7. Quit"+ANSI_RESET);
        }
        System.out.println(GREEN_BRIGHT+"8. Info" + ANSI_RESET);
        if (hero.allowed_options[7]==0){
            System.out.println(RED_BRIGHT + "9. Use Potion" + ANSI_RESET);
        }
        else {
            System.out.println(GREEN_BRIGHT+ "9. Use Potion" + ANSI_RESET);
        }
        if (hero.allowed_options[8]==0){
            System.out.println(RED_BRIGHT+"10. Go to Market" + ANSI_RESET);
        }
        else {
            System.out.println(GREEN_BRIGHT+"10. Go to Market" + ANSI_RESET);
        }
        if (hero.allowed_options[9]==0){
            System.out.println(RED_BRIGHT+"11. Change Equipment"+ANSI_RESET);
        }
        else {
            System.out.println(GREEN_BRIGHT+"11. Change Equipment"+ANSI_RESET);
        }

    }

    public static void print_attack_instruction(Hero h, ArrayList<Monster> monsters, MonsterTeam monster_team) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        System.out.println("Please choose the monster you want to attack: ");
        for (int i = 0; i < monsters.size(); i++){
            System.out.println(i+1 + ". " + monsters.get(i).get_name());
        }
        int pick;
        while(true){
            try {
                pick = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The input is not a number. Please re-enter:");
                continue;
            }
            if (pick > 0 && pick <= monsters.size()){
                System.out.println("Please choose the way you want to attack:");
                System.out.println("1. Attack with your weapon:");
                System.out.println("2. Attack with a spell:");
                int option;
                while(true){
                    try {
                        option = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("The input is not a number. Please re-enter:");
                        continue;
                    }
                    if (option == 1){
                        Monster m = monsters.get(pick-1);
                        System.out.println(h.get_name() + " deals " +
                                m.take_damage(h.get_damage()) +
                                " damage to " + m.get_name() + " with an auto attack!");
                        System.out.println(m.get_name() + " now has " + m.get_hp() + " hp!");
                        Music.play_weapon_attack_music();
                        if (!m.isAlive()){
                            monster_team.remove_monster(m);
                        }
                        return;
                    }
                    else if (option == 2){
                        Inventory h_gear = h.get_gears();
                        if (h_gear.get_spell_num() == 0){
                            System.out.println("You don't have any spells, please use weapon to attack:");
                            continue;
                        }
                        h_gear.print_spell();
                        System.out.println("Please choose the spell you want to use:");
                        int spell_num;
                        while(true) {
                            try {
                                spell_num = Integer.parseInt(input.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("The input is not a number. Please re-enter:");
                                continue;
                            }
                            if (spell_num > 0 && spell_num <= h_gear.get_spell_num()) {
                                Monster m = monsters.get(pick - 1);
                                System.out.println(h.get_name() + " deals " +
                                        m.take_damage(h_gear.get_spell(spell_num-1).get_damage(h.get_dexterity())) +
                                        " damage to " + m.get_name() + " with a spell!");
                                System.out.println(m.get_name() + " now has " + m.get_hp() + " hp!");
                                h_gear.get_spell(spell_num-1).play_spell_music();
                                if (!m.isAlive()){
                                    monster_team.remove_monster(m);
                                }
                                return;
                            }
                        }
                    }
                    System.out.println("The input number is invalid. Please re-enter:");
                }
            }
            System.out.println("The input number is invalid. Please re-enter:");
        }

    }

    public static void print_winner(int winner){
        if (winner==1){
            System.out.println("Heroes won!");
        }
        else if (winner ==0){
            System.out.println("Monsters won!");
        }
    }

    public static void print_hero_info(Hero hero){
        System.out.println(">>> Hero Information Table:");
        System.out.println("No. \t Name \t\t\t Health \t Strength \t Agility \t Dexterity");
        System.out.println("=== \t ================= \t ====== \t ======== \t ======= \t =========");

        System.out.println("1" + "\t " + padRight(hero.name, 24) + hero.hp
                + "\t\t " + hero.strength
                + "\t\t " + hero.agility
                + "\t\t " + hero.dexterity);


    }

    public static void print_market_welcome(){
        System.out.println("...............Welcome to the Market...............");
    }
}
