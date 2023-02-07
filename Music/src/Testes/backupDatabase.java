package Testes;

import Control.PopUp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class backupDatabase {
    
    private FileReader file = null;
    private BufferedReader bufferFile = null;
    private String res = null;
    
    private String readUser(String filePath) {
        try {
            setFile(new FileReader(filePath));
            setBufferFile(new BufferedReader(getFile()));
            try {
                setRes(getBufferFile().readLine());
                while(getRes() != null) {
                    if(getRes().indexOf("INSERT INTO user") == 0) {
                        return getRes();
                    }
                    setRes(getBufferFile().readLine());
                }
//                getFile().close();
//                return (String) getTextFile();
                
            } catch (IOException error) {
                // Caso gere um erro
                PopUp.showAlert("Backup não funcionou!", "perigo!!!");
                return null;
                
            } finally {
                // Finaliza zerando a variável linha
//                setAbsoluteTextFile("");
            }
        } catch (FileNotFoundException error) {
            PopUp.showAlert("Backup não funcionou!", "perigo!!!");
            return null;
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new backupDatabase().readUser("src/resources/bancoTeste.sql"));
    }
    
//    private String readMusic(String filePath) {}
//    private String readAvatar(String filePath) {}
//    private String readArtist(String filePath) {}
    
//    public String Read(String filePath) {
//        try {
//            FileReader file = new FileReader(filePath);
//            BufferedReader fileRead = new BufferedReader(file);
//            linha = "";
//            try {
//                linha = fileRead.readLine();
//                while (linha != null) {
//                    setTextFile(linha + "\n");
//                    linha = fileRead.readLine();
//                }
//                file.close();
//                return (String) getTextFile();
//                
//            } catch (IOException error) {
//                // Caso gere um erro
//                PopUp.showAlert("Backup não funcionou!", "perigo!!!");
//                return null;
//                
//            } finally {
//                // Finaliza zerando a variável textFile
//                setAbsoluteTextFile("");
//            }
//        } catch (FileNotFoundException error) {
//            PopUp.showAlert("Backup não funcionou!", "perigo!!!");
//            return null;
//        }
//    }

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
     * @return the file
     */
    public FileReader getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(FileReader file) {
        this.file = file;
    }

    /**
     * @return the bufferFile
     */
    public BufferedReader getBufferFile() {
        return bufferFile;
    }

    /**
     * @param bufferFile the bufferFile to set
     */
    public void setBufferFile(BufferedReader bufferFile) {
        this.bufferFile = bufferFile;
    }

    /**
     * @return the res
     */
    public String getRes() {
        return res;
    }

    /**
     * @param res the linha to set
     */
    public void setRes(String res) {
        this.res = res;
    }
}