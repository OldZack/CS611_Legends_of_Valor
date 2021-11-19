import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Hero extends Character{
    protected int mana;
    protected int exp;
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int money;
    protected Inventory gears;
    protected int max_mana;
    protected int max_hp;
    protected int position;
    protected Weaponry weapon;
    protected Armory armer;
    protected int[] allowed_options;
    protected int increase_due_to_cell;

    Hero(String n, int l, int m, int s, int a, int d, int mo, int e){
        super(n, l);
        mana = m;
        strength = s;
        dexterity = d;
        agility = a;
        exp = e;
        money = mo;
        gears = new Inventory();
        max_mana = mana;
        max_hp = 100;
        this.allowed_options= new int[]{1,1,1,1,1,1,1,1,1,1};
        this.increase_due_to_cell=0;

        weapon = new Weaponry("Stick", 0, 1, 0, 1);
        armer = new Armory("Plain Clothes", 0, 1, 0);
    }
    public int get_increase_due_to_cell(){
        return this.increase_due_to_cell;
    }

    public void set_increase_due_to_cell(int increase){
        this.increase_due_to_cell=increase;
    }

    public int get_mana(){
        return mana;
    }
    public int get_dexterity(){
        return dexterity;
    }
    public int get_damage(){ return (int)((strength+weapon.get_damage())*0.05); }
    public int get_money(){
        return money;
    }
    public int get_position(){ return position; }
    public Inventory get_gears(){ return gears;}
    public void reset_hp(double ratio){ hp += max_hp*ratio; }
    public void reset_mana(double ratio){ mana += max_mana*ratio; }
    public int[] get_allowed_options(){
        return this.allowed_options;
    }
    public void set_allowed_options(int[] allowed_options){
        this.allowed_options=allowed_options;
    }


    public int take_damage(int d){
        if (Math.random() < agility*0.0002){
            return 0;
        }
        int actual_damage = (int)(d*(1-((dexterity+armer.get_damage_reduction())*0.0002)));
        if (actual_damage < 0){
            actual_damage = 0;
        }
        hp -= actual_damage;
        if (hp <= 0){
            System.out.println(name + " falls down!");
            hp = 0;
        }
        return actual_damage;
    }

    public void change_money(int num){ money += num;}
    public void change_mana(int num){ mana += num;}
    public void change_exp(int num){ exp += num;}
    public void change_position(int p){ position = p; }

    public void update_weapon(Weaponry w){
        gears.add_weapon(weapon);
        weapon = w;
        gears.remove_weapon(w);
    }
    public void update_armer(Armory a){
        gears.add_arm(armer);
        armer = a;
        gears.remove_armor(a);
    }

    public void print_status(){
        System.out.format("%-20s%-7d%-6d%-16d\n", name, level, hp, mana);
    }

    abstract public void print_detailed_status();

    public void check_level_up(){
        if (level == 10){
            return;
        }
        if (exp >= level*10){
            System.out.println(name + " leveled up! All attributes increased!");
            this.increase_attributes();
            /*if (Objects.equals(role, "Warriors")){
                strength *= 1.1;
                dexterity *= 1.05;
                agility *= 1.1;
            }
            else if (Objects.equals(role, "Sorcerers")){
                strength *= 1.05;
                dexterity *= 1.1;
                agility *= 1.1;
            }
            else if (Objects.equals(role, "Paladins")){
                strength *= 1.1;
                dexterity *= 1.1;
                agility *= 1.05;
            }*/
            max_hp += 100;
            max_mana += 50;
            exp = exp%(level*10);
            level += 1;
        }
    }

    abstract public void increase_attributes();

    public void drink_potion(Potion p){
        try {
            Music.play_potion_music();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        String [] att = p.get_attribute();
        for (int i = 0; i < att.length; i++){
            if (Objects.equals(att[i], "Health")){
                hp += p.get_increase();
                System.out.println("You drank a health potion. HP increased by " + p.get_increase());
            }
            else if (Objects.equals(att[i], "Mana")){
                mana += p.get_increase();
                System.out.println("You drank a Mana potion. Mana increased by " + p.get_increase());
            }
            else if (Objects.equals(att[i], "Strength")){
                strength += p.get_increase();
                System.out.println("You drank a Strength potion. Strength increased by " + p.get_increase());
            }
            else if (Objects.equals(att[i], "Dexterity")){
                dexterity += p.get_increase();
                System.out.println("You drank a Dexterity potion. Dexterity increased by " + p.get_increase());
            }
            else if (Objects.equals(att[i], "Agility")){
                agility += p.get_increase();
                System.out.println("You drank an Agility potion. Agility increased by " + p.get_increase());
            }
        }
        gears.remove_potion(p);
        if (gears.get_potion_num()==0){
            allowed_options[7]=0;
        }

    }

    public boolean isAlive(){
        if (hp == 0){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean detect_enemy(Monster m){
        if (!(m.get_position() == this.position-1) && !(m.get_position() == this.position+1)
                    && !(m.get_position() == this.position-10)  && !(m.get_position() == this.position+10)
                    && !(m.get_position() == this.position-11)  && !(m.get_position() == this.position-9)
                    && !(m.get_position() == this.position+9)  && !(m.get_position() == this.position+11)){
            return false;
        }
        else{
            return true;
        }
    }

    public void check_equips(){
        Scanner option = new Scanner(System.in);
        first_loop:
        while (true){
            System.out.println(name);
            System.out.println("\nArmors:");
            gears.print_armor();
            System.out.println("------------------------------------------------------------------");
            System.out.println("\nWeapons:");
            gears.print_weapon();
            System.out.println("------------------------------------------------------------------");
            System.out.println("What do you want to do?");
            System.out.println("a.Change Armor    b.Change Weapon     c.Back     ");

            String command;
            while (true) {
                command = option.nextLine();
                if (Objects.equals(command, "a") || Objects.equals(command, "b")) {
                    break;
                }
                else if (Objects.equals(command, "c")){
                    break first_loop;
                }
            }
            System.out.println("Equip/Use the item by entering the number in front (Enter 0 to go back to last menu): ");
            int num;
            while (true) {
                try {
                    num = Integer.parseInt(option.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("The input is not a number. Please re-enter:");
                    continue;
                }
                if (num == 0){
                    break;
                }
                if (command.equals("a")){
                    if (num > 0 && num <= gears.get_armor_num()){
                        update_armer(gears.get_armor(num-1));
                        break;
                    }
                }
                else if (command.equals("b")){
                    if (num > 0 && num <= gears.get_weapon_num()){
                        update_weapon(gears.get_weapon(num-1));
                        break;
                    }
                }
                System.out.println("Input is invalid. Please re-enter: ");
            }
        }
    }
}
