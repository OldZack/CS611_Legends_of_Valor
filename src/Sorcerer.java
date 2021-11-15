public class Sorcerer extends Hero{

    Sorcerer(String n, int l, int m, int s, int a, int d, int mo, int e){
        super(n, l, m, s, a, d, mo, e);
    }

    @Override
    public void print_detailed_status() {
        System.out.format("%-20s%-11s%-7d%-6d%-6d%-10d%-10d%-10d%-6d%-6d%-10s%-15s\n", name, "Sorcerer", level, hp, mana, strength, dexterity, agility, money, exp, weapon.get_name(), armer.get_name());
    }

    @Override
    public void increase_attributes() {
        this.strength *= 1.1;
        this.dexterity *= 1.05;
        this.agility *= 1.1;
    }
}
