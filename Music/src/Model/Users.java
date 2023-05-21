package Model;

import java.util.ArrayList;

public class Users extends Database {

    public Users(String table) {
        super(table);
    }

    public boolean createUser(Object[] data) {
        return create(new String[]{"ulogin", "upassword", "utype"}, data);
    }

    public boolean loginUser(String login, String password) {
        return read("WHERE ulogin = ? AND upassword = sha2(?, 512) LIMIT 1", new Object[]{login, password});
    }

    public ArrayList<Object[]> readUser(String login, String password, String[] fields) {
        return read("WHERE ulogin = ? AND upassword = sha2(?, 512) LIMIT 1", new Object[]{login, password}, fields, null);
    }

    public ArrayList<Object[]> readUser(String aditional, Object[] fields, String[] results) {
        return read(aditional, fields, results, null);
    }

    public ArrayList<Object[]> readUser(int uid, String[] fields) {
        return read("WHERE uid = ?", new Object[]{uid}, fields, null);
    }

    public boolean updateUser(String[] fields, Object[] data, int uid) {
        return update(fields, data, "uid", uid);
    }

    public boolean deleteUser(int uid) {
        return delete("uid", uid);
    }
}
