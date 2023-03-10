package Model;

import Control.Config;
import Control.PopUp;
import java.io.File;
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
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * @author Kaik D' Andrade
 * @author Gabriel Souza
 */
public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/idealmusic?user=root&password=";
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    public String sql;

    /**
     * Método responsável por realizar a conexão com o banco de dados
     */
    public void setConnection() {
        try {
            // Inicializa a conexão se ocorrer nenhum error
            setConn(DriverManager.getConnection(URL));

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning(error);
        }
    }

    /**
     * Método responsável por finalizar a conexão com o banco de dados
     */
    public void setClose() {
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

    public String readMusic(int mid) {

        // Comando SQL
        sql = "SELECT msound FROM music WHERE mid = ?";

        try {

            setConnection();
            setPstm(getConn().prepareStatement(sql));

            getPstm().setInt(1, mid);

            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                return getRes().getString("msound");
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("ConfigMusic\\readMusic\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco 
            setClose();
            sql = null;
        }

        return null;
    }

    /**
     * Método responsável por criar um novo usuário no banco de dados, seja ele
     * funcionário ou artista
     *
     * @param uname
     * @param utel
     * @param ulogin
     * @param upassword
     * @author Kaik D' Andrade
     * @param utype
     */
    public void createUser(String uname, String utel, String ulogin, String upassword, String utype) {

        int id = 0;

        // Comando SQL
        sql = "INSERT INTO users(uname, utel, ulogin, upassword, utype) VALUES (?, ?, ?, sha2(?, 512), ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, uname);
            getPstm().setString(2, utel);
            getPstm().setString(3, ulogin);
            getPstm().setString(4, upassword);
            getPstm().setString(5, utype);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            setPstm(getConn().prepareStatement("SELECT * FROM users ORDER BY uid DESC LIMIT 1"));
            setRes(getPstm().executeQuery());
            if (getRes().next()) {
                id = getRes().getInt("uid");

                switch (getRes().getString("utype")) {
                    case "employee" -> {
                        sql = "INSERT INTO employee(emuser) VALUES (?)";
                        setPstm(getConn().prepareStatement(sql));
                        getPstm().setInt(1, id);
                        getPstm().execute();
                        PopUp.showNotefy("Sucesso!!! Funcionário cadastrado.");
                        break;
                    }

                    case "artist" -> {
                        sql = "INSERT INTO artist(artuser) VALUES (?)";
                        setPstm(getConn().prepareStatement(sql));
                        getPstm().setInt(1, id);
                        getPstm().execute();
                        PopUp.showNotefy("Sucesso!!! Artista cadastrado.");
                        break;
                    }

                    default -> {
                        break;
                    }
                }
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createUser\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    public ArrayList<Object[]> readMusicforArtist(int userId) {

        ArrayList<Object[]> musics = new ArrayList<>();

        sql = "SELECT * FROM music m "
                + "INNER JOIN enclose e ON m.mid = e.enmusic "
                + "INNER JOIN album a ON e.enalbum = a.alid "
                + "WHERE a.alartist = ?";

        try {

            setConnection();
            setPstm(getConn().prepareStatement(sql));

            getPstm().setInt(1, userId);

            setRes(getPstm().executeQuery());

            while (getRes().next()) {
                Object[] abacate = {
                    getRes().getInt("mid"),
                    getRes().getString("mname")
                };

                musics.add(abacate);
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readMusicforArtist\n" + error);
            return null;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }

        return musics;
    }

    public ArrayList<Object[]> readAlbumforArtist(int userId) {

        ArrayList<Object[]> musics = new ArrayList<>();

        sql = "SELECT * FROM album WHERE alartist = ?";

        try {

            setConnection();
            setPstm(getConn().prepareStatement(sql));

            getPstm().setInt(1, userId);

            setRes(getPstm().executeQuery());

            while (getRes().next()) {
                Object[] abacate = {
                    getRes().getInt("alid"),
                    getRes().getString("alname")
                };

                musics.add(abacate);
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readMusicforArtist\n" + error);
            return null;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }

        return musics;
    }

    /**
     * Método responsável por realizar o login do usuário no banco de dados
     *
     * @param login
     * @param password
     * @return
     * @author Kaik D' Andrade
     */
    public String readUser(String login, String password) {

        // Comando SQL
        sql = "SELECT * FROM users WHERE ulogin = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));
            getPstm().setString(1, login);
            getPstm().setString(2, password);

            // Executa o comando SQL no banco de dados
            setRes(getPstm().executeQuery());

            // Se for true, salva o dado do campo `field` dentro de `data`
            if (getRes().next()) {
                return switch (getRes().getString("utype")) {

                    case "artist" ->
                        getRes().getString("ulogin") + ";" + getRes().getInt("uid");

                    default ->
                        "NOT";
                };
            }

            return null;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readUser\n" + error);

            // Retorna null
            return null;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por alterar os dados de nome e email do usuário
     *
     * @param user
     * @return
     * @author Gabriel Souza
     */
    public boolean updateUser(Users user) {

        // Comando SQL
        sql = "UPDATE users SET uname = ?, utel = ?, ulogin = ?, upassword = sha2(?, 512) WHERE uid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, user.getUname());
            getPstm().setString(2, user.getUtel());
            getPstm().setString(3, user.getUlogin());
            getPstm().setString(4, user.getUpassword());
            getPstm().setInt(5, user.getUid());

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Retorna true
            return true;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\updateUser\n" + error);

            // Retorna false
            return false;

        } finally {
            // Finaliza a toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método resposável por cadastrar uma nova música no banco de dados
     *
     * @param music
     * @author Kaik D' Andrade
     */
    public void createMusic(Music music) {

        int idCategory = 0;
        int idMusic = 0;

        try {
            // Comando SQL
            sql = "SELECT cid FROM category WHERE cname = ?";

            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, music.getMcategory());
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                idCategory = getRes().getInt("cid");
            }

            // Comando SQL
            sql = "INSERT INTO music(mname, msound, mduration, myear, mcategory) VALUES (?, ?, ?, ?, ?)";

            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, music.getMname());
            getPstm().setString(2, music.getMsound().substring(music.getMsound().lastIndexOf("\\") + 1));
            getPstm().setString(3, music.getMduration());
            getPstm().setString(4, music.getMyear());
            getPstm().setInt(5, idCategory);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            // Comando SQL
            sql = "SELECT * FROM music ORDER BY mid DESC LIMIT 1";

            setPstm(getConn().prepareStatement(sql));

            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                idMusic = getRes().getInt("mid");
            }

            sql = "SELECT alid FROM album WHERE alname = ?";
            setPstm(getConn().prepareStatement(sql));
            getPstm().setString(1, music.getMalbum());
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                sql = "INSERT INTO enclose(enalbum, enmusic) VALUES (?, ?)";
                setPstm(getConn().prepareStatement(sql));
                getPstm().setInt(1, getRes().getInt("alid"));
                getPstm().setInt(2, idMusic);
            }

            // Copia a música para a pasta do projeto
            Path source = Paths.get(music.getMsound());
            Path destination = Paths.get(Config.retPath("sounds") + "/" + music.getMsound().substring(music.getMsound().lastIndexOf("\\") + 1));
            Files.copy(source, destination);

            PopUp.showNotefy("Sucesso!!! Música cadastrada.");

        } catch (IOException | SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createMusic\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por criar um novo albúm no banco de dados
     *
     * @param ulogin
     * @param alname
     * @author Kaik D' Andrade
     */
    public void createAlbum(String ulogin, String alname) {
        try {
            // Comando SQL
            sql = "SELECT * FROM users WHERE ulogin = ?";

            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, ulogin);
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                System.out.println("foi?");
                // Comando SQL
                sql = "INSERT INTO album(alname, alartist) VALUES (?, ?)";

                setPstm(getConn().prepareStatement(sql));

                // Alterando os "?" pelos valores corretos
                getPstm().setString(1, alname);
                getPstm().setInt(2, getRes().getInt("uid"));

                // Executa o comando SQL no banco de dados
                getPstm().execute();

                PopUp.showNotefy("Sucesso!!! Albúm cadastrado.");
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createAlbum\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por cadastrar uma nova categoria no banco de dados
     *
     * @param name
     * @author Kaik D' Andrade
     */
    public void createCategory(String name) {

        // Comando SQL
        sql = "INSERT INTO category(cname) VALUES (?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, name);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            PopUp.showNotefy("Sucesso!! Categorial musical cadastrada!");

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\createCategory\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por retornar todas as músicas que há em um albúm
     *
     * @param idAlbum
     * @return
     * @author Gabriel Souza
     */
    public ArrayList<Object[]> readMusicForAlbum(int idAlbum) {

        // Vareavel que armazenará os dados que vierem do banco de dados
        ArrayList<Object[]> data = new ArrayList<>();

        try {
            // Comando SQL
            sql = "SELECT * FROM enclose WHERE enalbum = ?";
            setConnection();
            setPstm(getConn().prepareStatement(sql));
            getPstm().setInt(1, idAlbum);
            setRes(getPstm().executeQuery());

            while (getRes().next()) {
                // Comando SQL
                sql = "SELECT * FROM music WHERE mid = ?";
                setPstm(getConn().prepareStatement(sql));
                getPstm().setInt(1, getRes().getInt("enmusic"));
                ResultSet musicResult = getPstm().executeQuery();

                while (musicResult.next()) {
                    Object[] abacate = {
                        musicResult.getString("mid"),
                        musicResult.getString("mname")
                    };

                    data.add(abacate);
                }
            }

            return data;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readMusicForAlbum\n" + error);

        } finally {
            // Finaliza a toda a conexão com o banco de dados
            setClose();
            sql = null;
        }

        return null;
    }

    /**
     * Método responsável por ler e retornar todas os registro de uma coluna de
     * alguma tabela do banco de dados
     *
     * @param table
     * @param field
     * @return
     */
    public ArrayList<String> readAll(String table, String... field) {

        // Inicializando a varíavel que armazena os dados vindo do banco de dados
        ArrayList<String> data = new ArrayList<>();

        // Varíavel...
        String newLine = "";

        // Comando SQL
        sql = "SELECT * FROM " + table;

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Executa o comando SQL no banco de dados
            setRes(getPstm().executeQuery());

            // Se for true, salva o dado do campo `field` dentro de `data`
            while (getRes().next()) {
                for (String field1 : field) {
                    newLine += getRes().getString(field1) + ";";
                }

                newLine = newLine.substring(0, newLine.lastIndexOf(";"));
                data.add(newLine);
                newLine = "";
            }

            return data;

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\readAll\n" + error);

            // Retorna null
            return null;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por excluir música
     *
     * @param id
     * @author Kaik D' Andrade
     */
    public void deleteMusic(int id) {

        // Comando SQL
        sql = "SELECT * FROM music WHERE mid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setInt(1, id);

            // Executa o comando SQL no banco de dados
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                String soundName = getRes().getString("msound");
                File fileSound = new File(Config.retPath("sounds") + soundName);
                fileSound.delete();
            }

            sql = "DELETE FROM music WHERE mid = ?";
            setPstm(getConn().prepareStatement(sql));
            getPstm().setInt(1, id);
            getPstm().execute();

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\deleteMusic\n" + error);

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por deletar um resgistro do banco de dados do banco de
     * dados
     *
     * @param id
     * @param campoId
     * @param table
     * @author Kaik D' Andrade
     */
    public void delete(int id, String campoId, String table) {

        // Verifica se o usuário confirmou a "exclusão" dos dados
        if (PopUp.showConfirm("Aviso:", "Deseja realmente excluir este usuário?")) {
            if (PopUp.showConfirmAlert("Realmente Deseja excluir esse registro.\nIsso Será permanente! Isto é sem volta!\\nAo clicar em proseguir automaticamente você assina o termo de responsabilidade...\nIsto é qualquer problema gerado por conta da exclusão desse dado cabe apenas a você!")) {

                // Comando SQL
                sql = "DELETE FROM ? WHERE ? = ?";

                try {
                    // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
                    setConnection();
                    setPstm(getConn().prepareStatement(sql));

                    // Altera os "?" pelos valores corretos
                    getPstm().setString(1, table);
                    getPstm().setString(2, campoId);
                    getPstm().setInt(3, id);

                    // Executa o comando SQL no banco de dados
                    getPstm().execute();

                } catch (SQLException error) {
                    // Caso gere um erro
                    PopUp.showWarning("DatabaseModel\\deleteUser\n" + error);

                } finally {
                    // Finaliza toda a conexão com o banco de dados
                    setClose();
                    sql = null;
                }
            }
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
}
