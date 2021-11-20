import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Music {

    public static void play_welcome_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Intro1.wav";
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
    public static void play_potion_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        play_glass_open_music();
        play_drinking_music();
        play_glass_close_music();

    }

    public static void play_drinking_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Drink.wav";
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
    public static void play_glass_open_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Glass_Open.wav";
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

    public static void play_glass_close_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Glass_Close.wav";
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

    public static void play_cash_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Cash.wav";
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

    public static void play_fire_spell_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Attack_Firespell.wav";
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

    public static void play_ice_spell_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Attack_Icespell.wav";
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

    public static void play_lightning_spell_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Attack_Lightningspell.wav";
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

    public static void play_weapon_attack_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Attack_Weapon.wav";
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

    public static void play_monster_attack_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Attack_Weapon.wav";
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



    public static void play_moving_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Hero_Move.wav";
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

    public static void play_teleport_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Teleport.wav";
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

    public static void play_change_armor_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Change_Armour.wav";
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
    public static void play_change_weapon_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Change_Weapon.wav";
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

    public static void play_hero_win_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Heroes_Win.wav";
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

    public static void play_monsters_win_music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        String filename = System.getProperty("user.dir") + "/src/files/" + "Monsters_Win.wav";
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
