package Model;

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
import java.util.Arrays;

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

    /**
     * Método responsável por retornar o caminho absoluto do projeto, até a
     * pasta `resources`
     *
     * @param folder
     * @return String
     * @author Kaik D' Andrade
     */
    public static String retPath(String folder) {
        Path parentPath = Paths.get("").toAbsolutePath();
        return parentPath.toString() + "/src/resources/" + folder;
    }

    /**
     * Método responsável por criar um novo usuário no banco de dados, seja ele
     * funcionário ou artista
     *
     * @param user
     * @author Kaik D' Andrade
     */
    public void createUser(Users user) {

        int id = 0;
        String utype = null;
        // Comando SQL
        sql = "INSERT INTO users(uname, utel, ulogin, upassword, utype) VALUES (?, ?, ?, sha2(?, 512), ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, user.getName());
            getPstm().setString(2, user.getTel());
            getPstm().setString(3, user.getLogin());
            getPstm().setString(4, user.getPassword());
            getPstm().setString(5, user.getType());

            // Executa o comando SQL no banco de dados
            getPstm().execute();

            setPstm(getConn().prepareStatement("SELECT * FROM users ORDER BY uid DESC LIMIT 1"));
            setRes(getPstm().executeQuery());
            if (getRes().next()) {
                id = getRes().getInt("uid");
                utype = getRes().getString("utype");
            }

            switch (utype) {
                case "employee" -> {
                    sql = "INSERT INTO employee(emuser) VALUES (?)";
                    setPstm(getConn().prepareStatement(sql));
                    getPstm().setInt(1, id);
                    getPstm().execute();
                    break;
                }

                case "artist" -> {
                    sql = "INSERT INTO artist(artuser) VALUES (?)";
                    setPstm(getConn().prepareStatement(sql));
                    getPstm().setInt(1, id);
                    getPstm().execute();
                    break;
                }

                default -> {
                    break;
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

    /**
     * Método responsável por realizar o login do usuário no banco de dados
     *
     * @param user
     * @return
     * @author Kaik D' Andrade
     */
    public int login(Users user) {

        // Comando SQL
        sql = "SELECT utype FROM users WHERE ulogin = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Altera os "?" pelos valores corretos
            getPstm().setString(1, user.getLogin());
            getPstm().setString(2, user.getPassword());

            // Executando o comando SQL no banco de dados
            setRes(pstm.executeQuery());

            if (getRes().next()) {
                return getRes().getInt("uid");

            } else {
                // Retorna nulo se tiver algum dado errado
                return 0;
            }

        } catch (SQLException error) {
            // Caso gere um erro
            PopUp.showWarning("DatabaseModel\\login\n" + error);

            // Retorna 0
            return 0;

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
            getPstm().setString(1, user.getName());
            getPstm().setString(2, user.getTel());
            getPstm().setString(3, user.getLogin());
            getPstm().setString(4, user.getPassword());
            getPstm().setInt(5, user.getId());

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
            getPstm().setString(1, music.getCategory());
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                idCategory = getRes().getInt("cid");
            }

            // Comando SQL
            sql = "INSERT INTO music(mname, msound, mcategory) VALUES (?, ?, ?)";

            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, music.getName());
            getPstm().setString(2, music.getSound().substring(music.getSound().lastIndexOf("/") + 1));
            getPstm().setInt(3, idCategory);

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
            getPstm().setString(1, music.getAlbum());
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                sql = "INSERT INTO enclose(enalbum, enmusic) VALUES (?, ?)";
                setPstm(getConn().prepareStatement(sql));
                getPstm().setInt(1, getRes().getInt("alid"));
                getPstm().setInt(2, idMusic);
            }

            // Copia a música para a pasta do projeto
            Path source = Paths.get(music.getSound());
            Path destination = Paths.get(retPath("sounds") + "/" + music.getSound().substring(music.getSound().lastIndexOf("/") + 1));
            Files.copy(source, destination);

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
     * @param abm
     */
    public void createAlbums(Albums abm) {

        int idArtist = 0;

        try {
            // Comando SQL
            sql = "SELECT uid FROM users WHERE cname = ?";

            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, abm.getArtist());
            setRes(getPstm().executeQuery());

            if (getRes().next()) {
                idArtist = getRes().getInt("uid");
            }

            // Comando SQL
            sql = "INSERT INTO album(alname, alartist) VALUES (?, ?)";

            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setString(1, abm.getName());
            getPstm().setInt(3, idArtist);

            // Executa o comando SQL no banco de dados
            getPstm().execute();

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
                for (int i = 0; i < field.length; i++) {
                    newLine += getRes().getString(field[i]) + ";";
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
                File fileSound = new File(retPath("sounds") + soundName);
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
