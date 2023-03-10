package Control;

import Model.Database;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Kaik D' Andrade
 */
public final class ConfigMusic {

    private Clip clip = null;
    boolean play = false;
    int musicDuraction = 0;
    private FloatControl gainControl = null;

    public ConfigMusic(int mid) {
        try {
            // Pega o arquivo da música (É necessário que o arquivo seja .wav a biblioteca usada não suporta .mp3)
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Config.retPath("sounds") + "/" + new Database().readMusic(mid)).getAbsoluteFile());

            // Abre/Define o arquivo da música na variável clip
            setClip(AudioSystem.getClip());
            getClip().open(audioInputStream);

            // Define aonde a música começa necessário para o botão de pausa
            getClip().setMicrosecondPosition(musicDuraction);

            // Define a variável de controle do volume e a defini com o normal
            setGainControl((FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN));
            getGainControl().setValue(0);

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException error) {
            // Caso gere um erro
            PopUp.showWarning("ConfigMusic\\Constructor\n" + error);
        }
    }

    public void start() {
        getClip().start();
    }

    public void volume(int volume) {
        getGainControl().setValue(volume);
    }

    public void notStop() {
        getClip().start();
        getClip().setMicrosecondPosition(musicDuraction);
    }
    
    public void stop() {
        getClip().stop();
        musicDuraction = (int) getClip().getMicrosecondPosition();
    }
    
    public void finalStop() {
        getClip().stop();
    }

    public double getDurationLenghtMusic() {
        return getClip().getMicrosecondLength();
    }

    public int getDurationMusic() {
        return (int) getClip().getMicrosecondPosition();
    }

    public void setDurationMusic(int duracao) {
        getClip().setMicrosecondPosition(duracao);
    }

    /**
     * @return the clip
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * @param clip the clip to set
     */
    public void setClip(Clip clip) {
        this.clip = clip;
    }

    /**
     * @return the gainControl
     */
    public FloatControl getGainControl() {
        return gainControl;
    }

    /**
     * @param gainControl the gainControl to set
     */
    public void setGainControl(FloatControl gainControl) {
        this.gainControl = gainControl;
    }
}
