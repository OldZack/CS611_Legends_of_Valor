import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class LightningSpell extends Spell{

    LightningSpell(String n, int c, int l, int d,int m){
        super(n, c, l, d, m);
    }

    public void spell_effects(Monster m){
        m.decrease_dodge();
    }

    @Override
    public void play_spell_music() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Music.play_lightning_spell_music();
    }
}
