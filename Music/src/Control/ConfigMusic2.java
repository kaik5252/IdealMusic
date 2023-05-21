import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class ConfigMusic2 {

    private Clip clip;
    private FloatControl volumeControl;

    public ConfigMusic2(String filePath) {
        try {
            URL audioUrl = getClass().getResource(filePath);
            if (audioUrl == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: " + filePath);
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(0);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException error) {
            error.printStackTrace();
        }
    }

    public void play() {
        //if (clip != null && !clip.isRunning()) {
            //clip.setFramePosition(0);
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
       // }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    public boolean isStopped() {
        return clip == null || !clip.isRunning();
    }

    public void setVolume(float volume) {
        if (volumeControl != null) {
            float min = volumeControl.getMinimum();
            float max = volumeControl.getMaximum();
            float value = (max - min) * volume + min;
            volumeControl.setValue(value);
        }
    }

    public static void main(String[] args) {
        String filePath = "resources/sounds/vicio.wav";
        try {
            ConfigMusic2 player = new ConfigMusic2(filePath);
            player.play();

            // Loop para verificar se a música está sendo reproduzida
            while (true) {
                if (player.isPlaying()) {
                    System.out.println("A música está sendo reproduzida...");
                } else {
                    System.out.println("A música parou de ser reproduzida.");
                    break;
                }
                // Aguarda um pequeno intervalo de tempo antes de verificar novamente
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Erro ao carregar o arquivo de áudio: " + e.getMessage());
        }
    }
}
