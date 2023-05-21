package Model;

import Control.PopUp;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/idealmusic?user=root&password=";
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet res;
    private String table;
    private String sql;

    public Database(String table) {
        this.table = table;
    }

    private Connection setConnection() {
        try {
            return DriverManager.getConnection(URL);

        } catch (SQLException error) {
            PopUp.showWarning("Problema no banco de dados, desculpe-nos.");
            return null;
        }
    }

    private void setClose() {
        if (res != null) try {
            res.close();
        } catch (SQLException ignore) {
        }

        if (pstm != null) try {
            pstm.close();
        } catch (SQLException ignore) {
        }

        if (conn != null) try {
            conn.close();
        } catch (SQLException ignore) {
        }

        sql = null;
    }

    private String getValuesForQuery(String[] arrayStr) {
        String str = "";
        for (int i = 1; i <= arrayStr.length; i++) {
            str += "?, ";
            if (i == arrayStr.length) {
                str = str.substring(0, str.length() - 2);
            }
        }
        return str;
    }

    private PreparedStatement resolvedPreparedStatement(PreparedStatement pstm, Object[] data) throws SQLException {
        for (int i = 0; i < data.length; i++) {
            if (data[i].getClass() == String.class) {
                pstm.setString(i + 1, (String) data[i]);

            } else if (data[i].getClass() == Integer.class) {
                pstm.setInt(i + 1, (int) data[i]);

            } else if (data[i].getClass() == Double.class) {
                pstm.setDouble(i + 1, (Double) data[i]);
            }
        }

        return pstm;
    }

    protected boolean create(String[] SQLValues, Object[] data) {
        try {
            sql = "INSERT INTO " + table + "(" + String.join(", ", SQLValues) + ") VALUES (" + getValuesForQuery(SQLValues) + ")";
            conn = setConnection();
            pstm = resolvedPreparedStatement(conn.prepareStatement(sql), data);

            return pstm.executeUpdate() > 0;

        } catch (SQLException error) {
            PopUp.showWarning("Erro ao adicionar dados ao banco de dados.\n" + error);
            return false;

        } finally {
            setClose();
        }
    }

    protected ArrayList<Object[]> read(String aditional, Object[] data, String[] results, String table) {
        try {
            aditional = aditional == null ? "" : " " + aditional;
            if (table == null) {
                sql = "SELECT * FROM " + this.table + aditional;
            } else {
                sql = "SELECT * FROM " + table + aditional;
            }
            conn = setConnection();
            if (!aditional.equals("")) {
                pstm = resolvedPreparedStatement(conn.prepareStatement(sql), data);
            } else {
                pstm = conn.prepareStatement(sql);
            }
            res = pstm.executeQuery();

            ArrayList<Object[]> resultList = new ArrayList<>();
            ResultSetMetaData metaData = (ResultSetMetaData) res.getMetaData();

            // Criar mapa para armazenar os tipos das colunas
            Map<String, Integer> columnTypes = new HashMap<>();

            // Preencher o mapa com os tipos das colunas usando os nomes das colunas fornecidos
            for (String columnName : results) {
                int columnIndex = -1;
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (columnName.equalsIgnoreCase(metaData.getColumnName(i))) {
                        columnIndex = i;
                        break;
                    }
                }
                if (columnIndex != -1) {
                    int columnType = metaData.getColumnType(columnIndex);
                    columnTypes.put(columnName, columnType);
                }
            }

            while (res.next()) {
                Object[] row = new Object[results.length];
                for (int i = 0; i < results.length; i++) {
                    String columnName = (String) results[i];
                    int columnType = columnTypes.get(columnName);

                    switch (columnType) {
                        case Types.VARCHAR:
                        case Types.CHAR:
                            row[i] = res.getString(columnName);
                            break;

                        case Types.INTEGER:
                        case Types.BIGINT:
                            row[i] = res.getInt(columnName);
                            break;

                        case Types.DOUBLE:
                            row[i] = res.getDouble(columnName);
                            break;

                        default:
                            row[i] = "NULL";
                            break;
                    }
                }
                resultList.add(row);
            }
            return resultList;

        } catch (SQLException error) {
            PopUp.showWarning("Erro ao ler os dados do banco de dados.\n" + error);
            return null;

        } finally {
            setClose();
        }
    }

    protected boolean read(String aditional, Object[] data) {
        try {
            aditional = aditional == null ? "" : " " + aditional;
            sql = "SELECT * FROM " + table + aditional;

            conn = setConnection();
            if (!aditional.equals("")) {
                pstm = resolvedPreparedStatement(conn.prepareStatement(sql), data);
            } else {
                pstm = conn.prepareStatement(sql);
            }
            res = pstm.executeQuery();
            return res.next();

        } catch (SQLException error) {
            PopUp.showWarning("Erro ao ler os dados do banco de dados.\n" + error);
            return false;

        } finally {
            setClose();
        }
    }

    protected boolean update(String[] fields, Object[] data, String SQLId, int id) {
        try {
            sql = "UPDATE " + table + " SET " + String.join(" = ?, ", fields) + " = ? WHERE " + SQLId + " = " + id;
            System.out.println(sql);
            conn = setConnection();
            pstm = resolvedPreparedStatement(conn.prepareStatement(sql), data);

            return pstm.executeUpdate() > 0;

        } catch (SQLException error) {
            PopUp.showWarning("Erro ao alterar os dados do banco de dados.\n" + error);
            return false;

        } finally {
            setClose();
        }
    }

    protected boolean delete(String SQLId, int id) {
        try {
            sql = "DELETE FROM " + table + " WHERE " + SQLId + " = ?";
            conn = setConnection();
            pstm = resolvedPreparedStatement(conn.prepareStatement(sql), new Object[]{id});

            return pstm.executeUpdate() > 0;

        } catch (SQLException error) {
            PopUp.showWarning("Erro ao deletar os dados do banco de dados.\n" + error);
            return false;

        } finally {
            setClose();
        }
    }

    /*
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
     */
}
