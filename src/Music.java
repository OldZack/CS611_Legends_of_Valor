import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    public static void play_welcome_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "intro.wav";
        File file = new File(filename);
        AudioInputStream am;
        am = AudioSystem.getAudioInputStream(file);
        AudioFormat af = am.getFormat();
        SourceDataLine sd;
        sd = AudioSystem.getSourceDataLine(af);
        sd.open();
        sd.start();
        int sumByteRead = 0;
        byte[] b = new byte[320];
        while (sumByteRead != -1) {
            sumByteRead = am.read(b, 0, b.length);
            if (sumByteRead >= 0) {
                sd.write(b, 0, b.length);
            }
        }
    }
}
