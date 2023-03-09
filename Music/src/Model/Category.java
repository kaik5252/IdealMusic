package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Category {
    
    private int cid;
    private String cname;

    public Category(int cid, String cname) {
        setCid(cid);
        setCname(cname);
    }
    
    public void createCategory() {
    
    }
    
    public void updateCategory() {
    
    }
    
    public void deleteCategory() {
    
    }
    
    /**
     * @return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        if(cname.trim().equals("")) {
            this.cname = null;
            
        } else {
            this.cname = cname;
        }
    }
}