import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class FireSpell extends Spell{

    FireSpell(String n, int c, int l, int d,int m){
        super(n, c, l, d, m);
    }

    public void spell_effects(Monster m){
        m.decrease_damage();
    }

    @Override
    public void play_spell_music() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Music.play_fire_spell_music();
    }
}
