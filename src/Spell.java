public abstract class Spell extends Gear implements ManaRequirement{

    private int damage;
    private int mana;

    Spell(String n, int c, int l, int d,int m){
        super(n,c,l);
        damage = d;
        mana = m;
    }

    @Override
    public boolean is_castable(int m) {
        return m >= mana;
    }

    public void print_spell(){
        System.out.format("\033[33m%-20s%-7d%-16d%-8d%-5d\n\033[m", name, cost, level, damage, mana);
    }

    public int get_damage(int dexterity){
        return (int) (damage*(0.5+dexterity/10000));
    }
    public int get_mana(){
        return mana;
    }

    public abstract void spell_effects(Monster m);
}
