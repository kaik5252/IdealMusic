package Model;

import java.util.ArrayList;

public class Album extends Database {

    public Album(String table) {
        super(table);
    }

    public boolean createAlbum(String ulogin, String alname) {
        ArrayList<Object[]> arrayData = read("WHERE ulogin = ? LIMIT 1", new Object[]{ulogin}, new String[]{"uid"}, "users");
        return create(new String[]{"alname", "alusers"}, new Object[]{arrayData.get(0)[0], alname});
    }

    public ArrayList<Object[]> readAlbum(int alusers, String[] results) {
        return read("WHERE alusers = ?", new Object[]{alusers}, results, null);
    }

    public ArrayList<Object[]> readAlbum(String aditional, Object[] data, String[] results) {
        return read(aditional, data, results, null);
    }

    public boolean updateAlbum(String[] fields, Object[] data, int alid) {
        return update(fields, data, "alid", alid);
    }

    public boolean deleteAlbum(int alid) {
        return delete("alid", alid);
    }
}
