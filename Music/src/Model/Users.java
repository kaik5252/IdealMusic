package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Users {

    private int uid;
    private String uname;
    private String utel;
    private String ulogin;
    private String upassword;
    private String utype;

    public Users(int uid, String uname, String utel, String ulogin, String password, String type) {
        setUid(uid);
        setUname(uname);
        setUtel(utel);
        setUlogin(ulogin);
        setUpassword(upassword);
        setUtype(utype);
    }

    public void createUser() {
        new Database().createUser(this);
    }

    public void readUser() {
        
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }

    /**
     * @return the uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * @return the uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname the name to set
     */
    public void setUname(String uname) {
        if (uname.trim().equals("") || uname.trim() == null) {
            this.uname = null;

        } else {
            this.uname = uname.trim();
        }
    }

    /**
     * @return the utel
     */
    public String getUtel() {
        return utel;
    }

    /**
     * @param utel the utel to set
     */
    public void setUtel(String utel) {
        if (utel.trim().equals("")) {
            this.utel = null;

        } else {
            this.utel = utel.trim();
        }
    }

    /**
     * @return the ulogin
     */
    public String getUlogin() {
        return ulogin;
    }

    /**
     * @param ulogin the ulogin to set
     */
    public void setUlogin(String ulogin) {
        if (ulogin.trim().equals("")) {
            this.ulogin = null;

        } else {
            this.ulogin = ulogin.trim();
        }
    }

    /**
     * @return the upassword
     */
    public String getUpassword() {
        return upassword;
    }

    /**
     * @param upassword the upassword to set
     */
    public void setUpassword(String upassword) {
        if (upassword.trim().equals("")) {
            this.upassword = null;

        } else {
            this.upassword = upassword.trim();
        }
    }

    /**
     * @return the utype
     */
    public String getUtype() {
        return utype;
    }

    /**
     * @param utype the utype to set
     */
    public void setUtype(String utype) {
        if (utype.trim().contains("artist") || utype.trim().contains("employee")) {
            this.utype = utype.trim();

        } else {
            this.utype = null;
        }
    }
}
