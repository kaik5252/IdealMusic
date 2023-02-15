package AppMusic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

public class Toque {
    private String caminho;

    public Toque(String caminho) {
        this.caminho = caminho;
    }

    public void start() {
        try {
            FileInputStream fileInputStream = new FileInputStream(caminho);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            Player player = new Player(bufferedInputStream);
            player.play();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}