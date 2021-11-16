public class FireSpell extends Spell{

    FireSpell(String n, int c, int l, int d,int m){
        super(n, c, l, d, m);
    }

    public void spell_effects(Monster m){
        m.decrease_damage();
    }
}
