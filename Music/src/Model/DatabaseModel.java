package Model;

import Control.PopUp;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * @author Kaik D' Andrade
 * @author Gabriel Souza
 */
public class DatabaseModel {

    private static final String URL = "jdbc:mysql://localhost:3306/idealmusic?user=root&password=";
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    public String sql;

    // Não faço a mínima ideia
    private File sourceFile;
    private File destinationFile;
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    public void conectDb() {
        try {
            // Inicializa a conexão se ocorrer nenhum error
            setConn(DriverManager.getConnection(URL));
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning(error);
        }
    }

    public void closeDb() {
        // Zera as variáveis referentes ao banco de dados
        if (getRes() != null) try {
            getRes().close();
        } catch (SQLException ignore) {
        }

        if (getPstm() != null) try {
            getPstm().close();
        } catch (SQLException ignore) {
        }

        if (getConn() != null) try {
            getConn().close();
        } catch (SQLException ignore) {
        }
    }

    // @author Kaik d' Andrade
    public static String retPath(String folder) {
        Path parentPath = Paths.get("").toAbsolutePath();
        return parentPath.toString() + "/src/resources/" + folder;
    }

    // @author Kaik D' Andrade
    public static void resize(String path, String fileName, String folder, int width, int height) {
        try {
            // Pega a extensão da imagem
            String extension = path.substring(path.lastIndexOf(".") + 1);

            // Carrega o diretorio final
            String finalPath = retPath(folder);

            // Carrega a imagem original
            BufferedImage originalImage = ImageIO.read(new File(path));

            // Cria uma nova imagem redimensionada
            Image newImage = originalImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.getGraphics().drawImage(newImage, 0, 0, null);

            // Salva a nova imagem na pasta do projeto
            File output = new File(finalPath + "/" + fileName + "." + extension);
            ImageIO.write(bufferedImage, extension, output);

        } catch (IOException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\resize\n" + error);
        }
    }

    // @author Gabriel Souza
    public void createUser(String userName, String userEmail, String userPass, String userType) {

        // Comando SQL
        sql = "INSERT INTO users(uname, uemail, upassword, uavatar, utype) VALUES (?, ?, sha2(?, 512), 1, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, userName);
            getPstm().setString(2, userEmail);
            getPstm().setString(3, userPass);
            getPstm().setString(4, userType);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Usuário criado, seja bem vindo(a).");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createUser\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

    // @author Kaik D' Andrade
    public int login(String userEmail, String userPassword) {

        // Comando SQL
        sql = "SELECT uid FROM users WHERE uemail = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Altera os "?" pelos valores corretos
            getPstm().setString(1, userEmail);
            getPstm().setString(2, userPassword);

            // Executando o comando SQL no banco de dados
            setRes(pstm.executeQuery());

            if (getRes().next()) {
                // Retorna o id do usuário se o email e a senha estiverem corretos
                return getRes().getInt("uid");

            } else {
                // Exibe uma mensagem de alerta ao usuário
                PopUp.showAlert("Email e/ou senha incorreto(s).\nVerifique os dados e tente novamente...");

                // Retorna 0 se tiver algum dos dados errados
                return 0;
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\login\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }

        return 0;
    }

    // @author Gabriel Souza
    public boolean updateUser(int userId, String userName, String userEmail) {

        // Comando SQL
        sql = "UPDATE users SET uname = ?, uemail = ? WHERE uid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, userName);
            getPstm().setString(2, userEmail);
            getPstm().setInt(3, userId);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Dados do usuário alterados.");

            // Retorna true
            return true;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\updateUser\n" + error);

            // Retorna false
            return false;

        } finally {
            // Finaliza a toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

    // @author Kaik D' Andrade
    public boolean setPassword(int userId, String oldPass, String newPass) {

        // Comando SQL
        sql = "SELECT * FROM users WHERE uid = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Altera os "?" pelos valores corretos
            getPstm().setInt(1, userId);
            getPstm().setString(2, oldPass);

            // Executando o comando SQL no banco de dados
            setRes(pstm.executeQuery());

            if (getRes().next()) {
                // Comando SQL
                sql = "UPDATE users SET upassword = sha2(?, 512) WHERE uid = ?";

                // Prepara, filtra e sanitiza o sql
                setPstm(getConn().prepareStatement(sql));

                // Altera os "?" pelos valores corretos
                getPstm().setString(1, newPass);
                getPstm().setInt(2, userId);

                // executa o comando no banco de dados
                getPstm().execute();

                // Exibe uma notificação ao usuário
                PopUp.showNotefy("Sucesso!!! Sua senha foi alterada.");

                // retorna true
                return true;

            } else {
                // Exibe uma mensagem de alerta ao usuário
                PopUp.showAlert("Senha incorreta, tente novamente...");

                // Retorna false
                return false;
            }
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\setPassword\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }

        return false;
    }

    // @author Kaik D' Andrade
    public void setAvatar() {
        // Depois...
    }

    // @author Gabriel Souza
    public void deleteUser(int userId) {

        // Verifica se o usuário confirmou a "exclusão" dos dados
        if (PopUp.showConfirm("Aviso:", "Deseja realmente excluir este usuário?")) {
            if (PopUp.showConfirmAlert("Realmente Deseja excluir esse registro.\nIsso Será permanente! Isto é sem volta!\\nAo clicar em proseguir automaticamente você assina o termo de responsabilidade...\nIsto é qualquer problema gerado por conta da exclusão desse dado cabe apenas a você!")) {

                // Comando SQL
                sql = "UPDATE users SET ustatus = 'del' WHERE uid = ?";

                try {
                    // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
                    conectDb();
                    setPstm(getConn().prepareStatement(sql));

                    // Altera os "?" pelos valores corretos
                    getPstm().setInt(1, userId);

                    // Executa o comando SQL no banco de dados
                    getPstm().execute();

                } catch (SQLException error) {
                    // Caso gere um erro
                    PopUp.showWarning("DatabaseModel\\deleteUser\n" + error);

                } finally {
                    // Finaliza toda a conexão com o banco de dados
                    closeDb();
                    sql = null;
                }
            }
        }
    }

    // @author Kaik D' Andrade
    public void createArtist(String artistName) {

        // Comando SQL
        sql = "INSERT INTO artist(aname) VALUES (?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, artistName);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Novo artista cadastrado.");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createArtist\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

    // @author Gabriel Souza
    public void updateArtist(int artId, String artName) {

        // Comando SQL
        sql = "UPDATE artist SET aname = ? WHERE aid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, artName);
            getPstm().setInt(2, artId);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Dados do artista alterados.");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\updateArtist\n" + error);

        } finally {

            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

    /**
     * Método resposável por cadastrar uma nova música no banco de dados
     *
     * @param musicName é o nome da música
     * @param bannerName é o nome do banner da música
     * @param bannerPath é o caminho(path) do banner no computador do usuário
     * @param soundName é o nome do arquivo da música
     * @param soundPath é o caminho do arquivo da música no computador do
     * usuário
     * @param ctg é o índice da categoria da música
     * @param artist é o artista da música
     */
    public void createMusic(String musicName, String bannerName, String bannerPath, String soundName, String soundPath, int ctg, String artist) {

        // Comando SQL
        sql = "INSERT INTO music(mname, mbanner, msound, mctg) VALUES (?, ?, ?, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, musicName);
            getPstm().setString(2, bannerName);
            getPstm().setString(3, soundName);
            getPstm().setInt(4, ctg);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Copia o banner para a pasta do projeto
            resize(bannerPath, bannerName, "banners", 150, 150);

            // Copia a música para a pasta do projeto
            Path source = Paths.get(soundPath);
            Path destination = Paths.get(retPath("sounds") + "/" + soundName);
            Files.copy(source, destination);

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Música cadastrada.");

        } catch (IOException | SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createMusic\n" + error);

        } finally {

            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

    /**
     * Método resposável por cadastrar uma nova música no banco de dados
     *
     * @param avatarName é o nome do arquivo do avatar
     * @param avatarPath é o caminho(path) do avatar no computador do usuário
     * @param status é o status do avatar
     */
    public void createAvatar(String avatarName, String avatarPath, String status) {

        // Comando SQL
        sql = "INSERT INTO avatar(avimg, avstatus) VALUES (?, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, avatarName);
            getPstm().setString(2, status);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Copia o avatar para a pasta do projeto
            resize(avatarPath, avatarName, "avatar", 100, 100);

            // Exibe uma notificação ao usuário
            PopUp.showNotefy("Sucesso!!! Avatar cadastrado.");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createAvatar\n" + error);

        } finally {

            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
        }
    }

//    public void editMusic(Music music) {
//
//        String sql = "UPDATE music SET  m_name = ?, m_duration = ?, m_banner = ?, m_music = ? WHERE id = ?";
//
//        try {
//
//            PreparedStatement stmt = this.conn.prepareStatement(sql);
//            stmt.setString(1, music.getName());
//            stmt.setInt(2, music.getDuration());
//            File image = new File("imagem.jpg");
//            fis = new FileInputStream(image);
//            stmt.setBinaryStream(3, fis, (int) image.length());
//            File audio = new File("musica.mp3");
//            fis = new FileInputStream(audio);
//            stmt.setBinaryStream(3, fis, (int) audio.length());
//            stmt.execute();
//
//        } catch (SQLException | FileNotFoundException erro) {
//
//            System.out.println("ERROR : " + erro.getMessage());
//
//        } finally {
//
//            dbClose(conn, null, null);
//
//        }
//
//    }
//
//
//
//    public void deleteMusic(int m_id) {
//
//        String sql = "DELETE FROM music WHERE m_id = ?";
//
//        try {
//
//            PreparedStatement stmt = this.conn.prepareStatement(sql);
//            stmt.setInt(1, m_id);
//            stmt.execute();
//
//        } catch (SQLException erro) {
//
//            System.out.println("ERROR : " + erro.getMessage());
//
//        }
//
//    }
    public ArrayList<String> readAll(String table, String limit, String field) {

        // Inicializando as varíaveis
        ArrayList<String> data = new ArrayList<>();
        limit = (limit == null) ? "" : " LIMIT " + limit;

        // Comando SQL
        sql = "SELECT * FROM " + table + "" + limit;

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Executa o comando SQL no banco de dados
            setRes(getPstm().executeQuery());

            // Se for true, salva o dado do campo `field` dentro de `data`
            while (getRes().next()) {
                data.add(getRes().getString(field));
            }

            return data;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readAll\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
            sql = null;
            data = null;
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new DatabaseModel().readAll("artist", null, "aname");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @return the conn
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * @param conn the conn to set
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * @return the pstm
     */
    public PreparedStatement getPstm() {
        return pstm;
    }

    /**
     * @param pstm the pstm to set
     */
    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    /**
     * @return the res
     */
    public ResultSet getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(ResultSet res) {
        this.res = res;
    }

    /**
     * @return the sourceFile
     */
    public File getSourceFile() {
        return sourceFile;
    }

    /**
     * @param sourceFile the sourceFile to set
     */
    public void setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    /**
     * @return the destinationFile
     */
    public File getDestinationFile() {
        return destinationFile;
    }

    /**
     * @param destinationFile the destinationFile to set
     */
    public void setDestinationFile(File destinationFile) {
        this.destinationFile = destinationFile;
    }

    /**
     * @return the fileInputStream
     */
    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    /**
     * @param fileInputStream the fileInputStream to set
     */
    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    /**
     * @return the fileOutputStream
     */
    public FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }

    /**
     * @param fileOutputStream the fileOutputStream to set
     */
    public void setFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }
}
