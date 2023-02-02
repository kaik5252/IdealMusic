package music;

import Control.ConfigMusic;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Exe extends JFrame {

    private static final ConfigMusic PLAY = new ConfigMusic("src/sapao.wav");

    public Exe() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        JSlider volume = new JSlider();
        volume.setMaximum(0);
        volume.setValue(0);
        volume.setMinimum(-80);
        volume.setOrientation(JSlider.VERTICAL);
        volume.setBounds(10, 5, 15, 100);
        volume.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                PLAY.volume(volume.getValue());
            }
        });

        JButton button1 = new JButton("Play");
        button1.setBounds(50, 0, 100, 30);
        button1.addActionListener((ActionEvent e) -> {
            PLAY.start();
        });

        JButton button2 = new JButton("Pause");
        button2.setBounds(50, 50, 100, 30);
        button2.addActionListener((ActionEvent e) -> {
            PLAY.stop();
        });

        add(button1);
        add(button2);
        add(volume);
        setMinimumSize(dim);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Exe");
        setVisible(true);
    }

    private void volumeStateChanged(javax.swing.event.ChangeEvent evt) {

    }

    public static void main(String[] args) {
        new Exe();
    }
}
