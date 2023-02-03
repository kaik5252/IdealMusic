package Control;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ConfigMusic {

    Clip clip = null;
    boolean reproducao = false;
    int inicio = 0;
    float volume = 0.0f;
    FloatControl gainControl = null;

    public ConfigMusic(String caminho) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(caminho).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.setMicrosecondPosition(inicio);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("Erro ao executar SOM!");
        }
    }

    public int getDurationMusicLenght() {
        return (int) clip.getMicrosecondLength();
    }
    
    public int getDurationMusic() {
        return (int) clip.getMicrosecondPosition();
    }
    
    public void setDurationMusic(int duracao) {
        clip.setMicrosecondPosition(duracao);
    }
    
    public void start() {
        if (reproducao == false) {
            clip.start();
            reproducao = true;
        }
    }

    public void volume(int volume) {
        this.volume = (float) volume;
        gainControl.setValue(volume);
    }

    public void stop() {
        if (reproducao) {
            clip.stop();
            inicio = (int) clip.getMicrosecondPosition();
            reproducao = false;
        }
    }
}
