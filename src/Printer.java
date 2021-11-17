import java.util.ArrayList;
import java.util.Scanner;
public class Printer {

    public static final String ANSI_RESET = "\u001B[0m";
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
    public static void print_LOV_gameboard_With_Positions(Gameboard gameboard){
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
                    if (i>0 && i<7 ) {
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
        for (int i = 0; i < 3; i++) {
            heroes.add(new int[]{(int) Math.floorDiv(hero_positions[i],10),(int) hero_positions[i]%10});
        }
        ArrayList<int[]> monsters = new ArrayList<int[]>();
        for (int i = 0; i < 3; i++) {
            monsters.add(new int[]{(int) Math.floorDiv(monster_positions[i],10),(int) monster_positions[i]%10});
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

    public static void print_gameboard(Gameboard gameboard, int[] current_place) {
        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+-----");
        }
        System.out.print("+");
        System.out.println();

        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("|");  // Print board edge before each row.
            for (int j = 0; j < gameboard.N; j++) {
                if (i == current_place[0] && j == current_place[1]) {
                    System.out.print("  **  ");
                    continue;
                }
                System.out.print("  " + gameboard.gameboard[i][j].get_symbol() + "  ");
            }

            System.out.print("|");  // Print board edge after each row.
            System.out.println("");
        }

        for (int i = 0; i < gameboard.N; i++) {
            System.out.print("+-----");
        }
        System.out.print("+");
        System.out.println("");

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

}
