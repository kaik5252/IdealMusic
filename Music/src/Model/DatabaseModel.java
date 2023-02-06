package Model;

import Control.PopUp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * @author Kaik D' Andrade
 * @author Gabriel Souza // Read // Update
 */
public class DatabaseModel {

    private static final ConfigDatabase DBCONFIG = new ConfigDatabase();
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet res = null;
    public String sql = null;

    // @author Gabriel Souza
    public void insertUser(String userName, String userEmail, String userPass, String userType) {

        // Comando SQL
        sql = "INSERT INTO usuario (u_name, u_email, u_passwd, u_type) VALUES (?, ?, sha2(?, 512), ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConn(DBCONFIG.getConnection());
            setPstm(getConn().prepareStatement(sql));

            // Alterando o "?" pelo valores corretos
            getPstm().setString(1, userName);
            getPstm().setString(2, userEmail);
            getPstm().setString(3, userPass);
            getPstm().setString(4, userType);

            // Executa o comando SQL no banco de dados
            getPstm().execute();
            
            PopUp.showNotefy("Sucesso!!! Usuário criado, seja bem vindo(a).");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning(error);

        } finally {
            // Finaliza a conexão com o banco de dados
            DBCONFIG.dbClose(getConn(), getPstm(), null);
        }
    }

    // @author Gabriel Souza
    public void updateUser(int userId, String userName, String userEmail) {

        // Comando SQL
        sql = "UPDATE usuario SET u_name = ?, u_email = ? WHERE u_id = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConn(DBCONFIG.getConnection());
            setPstm(getConn().prepareStatement(sql));
            
            // Alterando o "?" pelos valores corretos
            getPstm().setString(1, userName);
            getPstm().setString(2, userEmail);
            getPstm().setInt(3, userId);
            
            // Executa o comando SQL no banco de dados
            getPstm().execute();
            
            // Exibe um mensagem de conclusão
            PopUp.showNotefy("Sucesso!!! Dados alterados.");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning(error);

        } finally {
            // Finaliza a conexão com o banco de dados
            DBCONFIG.dbClose(getConn(), getPstm(), null);
        }
    }

    // @author Kaik D' Andrade
    public void setPassUser(int userId, String oldPass, String newPass) {

        // Comando SQL
        sql = "SELECT * FROM usuario WHERE u_id = " + userId;

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            setConn(DBCONFIG.getConnection());
            setPstm(getConn().prepareStatement(sql));

            // Armazenando o resultado e jogando ele na variável userPass
            setRes(getPstm().executeQuery(sql));
            getRes().next();
            String userPass = getRes().getString("u_passwd");

            // Verificando se a senha antiga passada como parâmetro está correta
            if (userPass.equals(oldPass)) {
                // Comando SQL
                sql = "UPDATE usuario SET u_passwd = ? WHERE u_id = ?";

                // Prepara, filtra e sanitiza o sql e depois troca os "?" pelos valores corretos e executa o comando SQL no banco
                setPstm(getConn().prepareStatement(sql));
                getPstm().setString(1, newPass);
                getPstm().setInt(2, userId);
                // executa o comando no banco de dados assim trocando a senha do usuário pela nova senha passada como parâmetro
                getPstm().execute();

                PopUp.showNotefy("Sucesso!!! Sua senha foi alterada.");
            } else {
                // exibe uma mensagem de alerta ao usuário
                PopUp.showAlert("Senha incorreta, tente novamente...");

                // Depois colocar aqui um método para limpar os campos
                /**
                 * 
                 */
            }
        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\setPassUser\n" + error);

        } finally {
            // Finaliza a conexão ao banco de dados
            DBCONFIG.dbClose(getConn(), getPstm(), getRes());
        }
    }

    // @author Gabriel Souza
    public void deleteUser(int userId) {

        // Comando SQL
        sql = "UPDATE usuario SET u_status = 'del' WHERE u_id = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConn(DBCONFIG.getConnection());
            setPstm(getConn().prepareStatement(sql));

            // Altera o "?" pelo id do usuário passado como parâmetro
            getPstm().setInt(1, userId);

            // executa o comando SQL no banco de dados
            getPstm().execute();

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\deleteUser\n" + error);

        } finally {
            // Finaliza a conexão ao banco de dados
            DBCONFIG.dbClose(getConn(), getPstm(), null);
        }
    }
    
    
//        public void insertMusic(Music music) throws FileNotFoundException {
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
}
