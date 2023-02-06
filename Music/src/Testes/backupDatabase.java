package Testes;

import Control.PopUp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class backupDatabase {
    
    private String textFile = "";
    String linha = null;
    
    public String Read(String filePath) {
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader fileRead = new BufferedReader(file);
            linha = "";
            try {
                linha = fileRead.readLine();
                while (linha != null) {
                    setTextFile(linha + "\n");
                    linha = fileRead.readLine();
                }
                file.close();
                return (String) getTextFile();
                
            } catch (IOException error) {
                // Caso gere um erro
                PopUp.showAlert("Backup não funcionou!", "perigo!!!");
                return null;
                
            } finally {
                // Finaliza zerando a variável textFile
                setAbsoluteTextFile("");
            }
        } catch (FileNotFoundException error) {
            PopUp.showAlert("Backup não funcionou!", "perigo!!!");
            return null;
        }
    }

    public void Write(String filePath, String text) {
        try {
            // Capta o arquivo
            FileWriter file = new FileWriter(filePath);
            
            // Grava o texto passado como parâmetro dentro do arquivo
            try (PrintWriter gravarArq = new PrintWriter(file)) {
                gravarArq.println(text);
            }
        } catch (IOException error) {
            // Caso gere um erro
            PopUp.showAlert("Backup não funcionou!", "Perigo!!!");
        }
    }

    /**
     * @return the textFile
     */
    public String getTextFile() {
        return textFile;
    }

    /**
     * @param textFile the textFile to set
     */
    public void setAbsoluteTextFile(String textFile) {
        this.textFile = textFile;
    }
    
    /**
     * @param textFile the textFile to set
     */
    public void setTextFile(String textFile) {
        this.textFile += textFile;
    }
}