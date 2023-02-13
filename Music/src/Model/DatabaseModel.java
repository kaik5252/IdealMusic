package Model;

import Control.PopUp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Kaik D' Andrade
 * @author Gabriel Souza // Read // Update
 */
public class DatabaseModel {

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet res = null;
    public String sql = null;
    private static final String URL = "jdbc:mysql://localhost:3306/teste?user=root&password=";
    private File sourceFile = null;
    private File destinationFile = null;
    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;

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

    // @author Gabriel Souza
    public void createUser(String userName, String userEmail, String userPass, String userType) {

        // Comando SQL
        sql = "INSERT INTO user(u_name, u_email, u_passwd, u_type) VALUES (?, ?, sha2(?, 512), ?)";

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
        }
    }

    // @author Kaik D' Andrade
    public void readUser(String userEmail, String userPassword) {

        // Comando SQL
        sql = "SELECT * FROM user WHERE u_email = ? AND u_password = sha2(?, 512)";

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
                /**
                 * Se for True....
                 */
            } else {
                // Exibe uma mensagem de alerta ao usuário
                PopUp.showAlert("Email e/ou senha incorreto(s).\nVerifique os dados e tente novamente...");

                // Depois colocar aqui um método para limpar o campo de senha
                /**
                 *
                 */
            }
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readUser\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
        }
    }

    // @author Gabriel Souza
    public void updateUser(int userId, String userName, String userEmail) {

        // Comando SQL
        sql = "UPDATE user SET u_name = ?, u_email = ? WHERE u_id = ?";

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

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\updateUser\n" + error);

        } finally {
            // Finaliza a toda a conexão com o banco de dados
            closeDb();
        }
    }

    // @author Kaik D' Andrade
    public void setPassword(int userId, String oldPass, String newPass) {

        // Comando SQL
        sql = "SELECT * FROM user WHERE u_id = ? AND u_password = sha2(?, 512)";

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
                sql = "UPDATE user SET u_password = ? WHERE u_password = sha2(?, 512)";

                // Prepara, filtra e sanitiza o sql
                setPstm(getConn().prepareStatement(sql));

                // Altera os "?" pelos valores corretos
                getPstm().setString(1, newPass);
                getPstm().setString(2, oldPass);

                // executa o comando no banco de dados
                getPstm().execute();

                // Exibe uma notificação ao usuário
                PopUp.showNotefy("Sucesso!!! Sua senha foi alterada.");

            } else {
                // Exibe uma mensagem de alerta ao usuário
                PopUp.showAlert("Senha incorreta, tente novamente...");

                // Depois colocar aqui um método para limpar os campos
                /**
                 *
                 */
            }
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\setPassword\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
        }
    }

    // @author Gabriel Souza
    public void deleteUser(int userId) {

        // Comando SQL
        sql = "UPDATE user SET u_status = 'del' WHERE u_id = ?";

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
        }
    }

    // @author Kaik D' Andrade
    public void createArtist(String artistName) {

        // Comando SQL
        sql = "INSERT INTO artist(u_name) VALUES (?)";

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
            PopUp.showWarning(error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            closeDb();
        }
    }

//    // @author Gabriel Souza Método em beta
//    public void readArtist() {
//
//        // Comando SQL
//        sql = "SELECT * FROM artist WHERE [...]";
//
//        try {
//            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
//            conectDb();
//            setPstm(getConn().prepareStatement(sql));
//
//            // Altera os "?" pelos valores corretos
//            // getPstm().setString(1, );
//
//            // Executando o comando SQL no banco de dados
//            setRes(pstm.executeQuery());
//
//        } catch (SQLException error) {
//
//            // Caso gere um erro
//            PopUp.showWarning("DatabaseModel\\readArtist\n" + error);
//
//        } finally {
//
//            // Finaliza toda a conexão com o banco de dados
//            closeDb();
//        }
//    }
    
    // @author Gabriel Souza
    public void updateArtist(int artId, String artName) {

        // Comando SQL
        sql = "UPDATE artist SET art_name = ? WHERE art_id = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, artName);
            getPstm().setInt(2, artId);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Exibe uma notificação ao artista
            PopUp.showNotefy("Sucesso!!! Dados do artista alterados.");

        } catch (SQLException error) {

            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\updateArtist\n" + error);

        } finally {

            // Finaliza toda a conexão com o banco de dados
            closeDb();
        }
    }

    // @author Gabriel Souza
    public void deleteArtist(int artId) {

        // Comando SQL
        sql = "DELETE FROM artist WHERE art_id = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            conectDb();
            setPstm(getConn().prepareStatement(sql));

            // Altera os "?" pelos valores corretos
            getPstm().setInt(1, artId);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

        } catch (SQLException error) {

            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\deleteArtist\n" + error);

        } finally {

            // Finaliza toda a conexão com o banco de dados
            closeDb();
        }
    }



// Método beta para copiar os arquivo para dentro do app
//    public void teste(String caminho, String destino) {
//        try {
//            setSourceFile(new File(caminho));
//            setDestinationFile(new File(destino));
//
//            set
//                    FileInputStream(new FileInputStream(getSourceFile()));
//            FileOutputStream fileOutputStream = new FileOutputStream(getDestinationFile());
//
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = fileInputStream.read(buffer)) > 0) {
//                fileOutputStream.write(buffer, 0, length);
//            }
//        } catch (IOException e) {
//
//        } finally {
//            getFileInputStream().close();
//            getFileOutputStream().close();
//        }
//    }

        // @author Gabriel Souza
//        public void insertMusic(Music music) {
//
//        String sql = "INSERT INTO music ( m_name, m_duration, m_banner, m_music) VALUES ( ?, ?, ?, ? )";
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