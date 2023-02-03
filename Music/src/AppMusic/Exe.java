package AppMusic;

import Control.ConfigMusic;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Exe extends JFrame {

    Timer timer = null;
    private static final ConfigMusic PLAY = new ConfigMusic("src/sapao.wav");

    public Exe() {
        JSlider duracao = new JSlider();
        duracao.setMaximum(0);
        duracao.setValue(0);
        duracao.setMaximum(PLAY.getDurationMusicLenght());
        duracao.setOrientation(JSlider.HORIZONTAL);
        duracao.setBounds(500, 500, 200, 20);
        ChangeListener changeListener = (ChangeEvent e) -> {
            PLAY.setDurationMusic(duracao.getValue());
        };
        duracao.addChangeListener(changeListener);

        timer = new Timer(2000, (ActionEvent e) -> {
            if (!duracao.getValueIsAdjusting()) {
                duracao.removeChangeListener(changeListener);
                duracao.setValue(PLAY.getDurationMusic());
                duracao.addChangeListener(changeListener);
            }
        });
        System.out.println(PLAY.getDurationMusicLenght());

        timer.start();
        JSlider volume = new JSlider();

        volume.setMaximum(0);
        volume.setValue(0);
        volume.setMinimum(-80);
        volume.setOrientation(JSlider.VERTICAL);

        volume.setBounds(10, 5, 15, 100);
        volume.addChangeListener(
                (ChangeEvent evt) -> {
                    PLAY.volume(volume.getValue());
                }
        );

        JButton button1 = new JButton("Play");

        button1.setBounds(50, 0, 100, 30);
        button1.addActionListener(
                (ActionEvent e) -> {
                    PLAY.start();
                }
        );

        JButton button2 = new JButton("Pause");

        button2.setBounds(50, 50, 100, 30);
        button2.addActionListener(
                (ActionEvent e) -> {
                    PLAY.stop();
                }
        );

        add(duracao);
        add(button1);
        add(button2);
        add(volume);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);

        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Exe");
        setVisible(true);
    }
}