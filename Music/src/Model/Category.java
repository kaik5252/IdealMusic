package Model;

import java.util.ArrayList;

public class Category extends Database {
    public Category(String table) {
        super(table);
    }
    
    public boolean createCategory(String cname) {
        return create(new String[]{"cname"}, new Object[]{cname});
    }
    
    public ArrayList<Object[]> readCategory(String aditional, Object[] data, String[] results) {
        return read(aditional, data, results, null);
    }
    
    public boolean updateCategory(String[] fields, Object[] data, int cid) {
        return update(fields, data, "cid", cid);
    }
    
    public boolean deleteCategory(int cid) {
        return delete("cid", cid);
    }
}