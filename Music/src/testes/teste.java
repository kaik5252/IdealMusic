package testes;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import java.io.File;

public class teste {

    public static void main(String[] args) {
        try {
        File mp3File = new File("C:\\Users\\greic\\Downloads/vicio.mp3");
        File target = new File("C:\\Users\\greic\\Downloads/abacate.wav");
        
        // Configurando os atributos da condificação
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("wmav1");
        audio.setBitRate(128000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("wav");
        attrs.setAudioAttributes(audio);
        
        // Realiza a codificação
        Encoder encoder = new Encoder();
        encoder.encode(mp3File, target, attrs);
        
        } catch(IllegalArgumentException | EncoderException e) {
            System.out.println(e);
        }
    }
}