package Model;

import Control.PopUp;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
import javax.imageio.ImageIO;

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
     * Método responsável por retornar todo o caminho(path) até a pasta
     * `resources` do projeto no computador do usuário
     *
     * @param folder é o diretório que fica dentro de `resources`, se quiser
     * referenciar `resources` deixe como ""
     * @return String
     * @author Kaik D' Andrade
     */
    public static String retPath(String folder) {
        Path parentPath = Paths.get("").toAbsolutePath();
        return parentPath.toString() + "/src/resources/" + folder;
    }

    /**
     * Método responsável por redimensionar uma imagem
     *
     * @param path é o caminho(path) da imagem no computador
     * @param fileName é o nome do arquivo da imagem
     * @param folder é a pasta na qual deve ser salva essa imagem (pasta dentro
     * de `resources`)
     * @param width é a largura de resize da imagem
     * @param height é a altura de resize da imagem
     * @author Kaik D' Andrade
     */
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

    /**
     * Método responsável por criar um novo usuário no banco de dados
     *
     * @param userName é o nome do usuário
     * @param userEmail é o email do usuário
     * @param userPass é a senha do usuário
     * @param userType é o tipo do usuário (user or adm)
     * @author Gabriel Souza
     */
    public void createUser(String userName, String userEmail, String userPass, String userType) {

        // Comando SQL
        sql = "INSERT INTO users(uname, uemail, upassword, uavatar, utype) VALUES (?, ?, sha2(?, 512), 1, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por realizar o login do usuário no banco de dados
     *
     * @param userEmail é o email do usuário
     * @param userPassword é a senha do usuário
     * @return int (0 => erro; >0 => idUser)
     * @author Kaik D' Andrade
     */
    public int login(String userEmail, String userPassword) {

        // Comando SQL
        sql = "SELECT uid FROM users WHERE uemail = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            setConnection();
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
     * @param userId é o id do usuário
     * @param userName é o nome do usuário
     * @param userEmail é o email do usuário
     * @return (false => erro; true => sucesso)
     * @author Gabriel Souza
     */
    public boolean updateUser(int userId, String userName, String userEmail) {

        // Comando SQL
        sql = "UPDATE users SET uname = ?, uemail = ? WHERE uid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
            sql = null;
        }
    }

    /**
     *
     * @param userId
     * @param oldPass
     * @param newPass
     * @return
     * @author Kaik D' Andrade
     */
    public boolean setPassword(int userId, String oldPass, String newPass) {

        // Comando SQL
        sql = "SELECT * FROM users WHERE uid = ? AND upassword = sha2(?, 512)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para exetuta-lo
            setConnection();
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

            // Retorna false
            return false;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
        }
    }

    // @author Kaik D' Andrade
    public void setAvatar() {
        // Depois...
    }

    /**
     * Método responsável por "deletar" o usuário do banco de dados
     *
     * @param userId é o id do usuário
     * @author Gabriel Souza
     */
    public void deleteUser(int userId) {

        // Verifica se o usuário confirmou a "exclusão" dos dados
        if (PopUp.showConfirm("Aviso:", "Deseja realmente excluir este usuário?")) {
            if (PopUp.showConfirmAlert("Realmente Deseja excluir esse registro.\nIsso Será permanente! Isto é sem volta!\\nAo clicar em proseguir automaticamente você assina o termo de responsabilidade...\nIsto é qualquer problema gerado por conta da exclusão desse dado cabe apenas a você!")) {

                // Comando SQL
                sql = "UPDATE users SET ustatus = 'del' WHERE uid = ?";

                try {
                    // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
                    setConnection();
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
                    setClose();
                    sql = null;
                }
            }
        }
    }

    /**
     * Método responsável por criar um novo usuário no banco de dados
     *
     * @param artistName é o nome do artista
     * @author Kaik D' Andrade
     */
    public void createArtist(String artistName) {

        // Comando SQL
        sql = "INSERT INTO artist(aname) VALUES (?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por alterar os dados de nome do artista
     *
     * @param artId é o id do artista
     * @param artName é o "novo" nome do artista
     * @author Gabriel Souza
     */
    public void updateArtist(int artId, String artName) {

        // Comando SQL
        sql = "UPDATE artist SET aname = ? WHERE aid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
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
     * @author Kaik D' Andrade
     */
    public void createMusic(String musicName, String bannerName, String bannerPath, String soundName, String soundPath, int ctg, String artist) {

        // Comando SQL
        sql = "INSERT INTO music(mname, mbanner, msound, mctg) VALUES (?, ?, ?, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
            sql = null;
        }
    }

    /**
     * Método resposável por cadastrar um novo avatar no banco de dados
     *
     * @param avatarName é o nome do arquivo do avatar
     * @param avatarPath é o caminho(path) do avatar no computador do usuário
     * @param status é o status do avatar
     * @author Kaik D' Andrade
     */
    public void createAvatar(String avatarName, String avatarPath, String status) {

        // Comando SQL
        sql = "INSERT INTO avatar(avimg, avstatus) VALUES (?, ?)";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            setClose();
            sql = null;
        }
    }

    /**
     * Método responsável por excluir música
     *
     * @param mid é id da música
     * @author Kaik D' Andrade
     * 
     * 
     * Método não terminado e ainda não testado...
     */
    public void deleteMusic(int mid) {
        
        // Comando SQL
        sql = "DELETE FROM music WHERE mid = ?";
        sql = "SELECT * FROM music WHERE mid = ?";

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
            setPstm(getConn().prepareStatement(sql));

            // Alterando os "?" pelos valores corretos
            getPstm().setInt(1, mid);

            // Executa o comando SQL no banco de dados
            setRes(getPstm().executeQuery());

            while (getRes().next()) {
                String bannerName = getRes().getString("banner");
                File fileBanner = new File(retPath("banners") + bannerName);
                fileBanner.delete();

                String soundName = getRes().getString("sound");
                File fileSound = new File(retPath("sounds") + soundName);
                fileSound.delete();
            }

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
     * Método responsável por ler e retornar todas os registro de uma coluna de alguma tabela do banco de dados
     * @param table é a tabela do banco de dados
     * @param limit é o limit da quantidade de retornos dos registros do banco de dados (pode ser null)
     * @param field é nome da coluna
     * @return
     */
    public ArrayList<String> readAll(String table, String limit, String field) {

        // Inicializando as varíaveis
        ArrayList<String> data = new ArrayList<>();
        limit = (limit == null) ? "" : " LIMIT " + limit;

        // Comando SQL
        sql = "SELECT * FROM " + table + "" + limit;

        try {
            // Conecta ao banco de dados, depois prepara, filtra e sanitiza o sql para executa-lo
            setConnection();
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
            
            // Retorna null
            return null;

        } finally {
            // Finaliza toda a conexão com o banco de dados
            setClose();
            sql = null;
            data = null;
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
