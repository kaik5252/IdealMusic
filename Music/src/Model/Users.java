package Model;

/**
 * @author Kaik D' Andrade
 */
public final class Users {

    private int id;
    private String name;
    private String tel;
    private String login;
    private String password;
    private String type;

    public Users(int id, String name, String tel, String login, String password, String type) {
        setId(id);
        setName(name);
        setTel(tel);
        setLogin(login);
        setPassword(password);
        setType(type);
    }

    public void createUser() {
        new Database().createUser(this);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.trim().equals("")) {
            this.name = null;

        } else {
            this.name = name.trim();
        }
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        if (tel.trim().equals("")) {
            this.tel = null;

        } else {
            this.tel = tel.trim();
        }
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        if (login.trim().equals("")) {
            this.login = null;

        } else {
            this.login = login.trim();
        }
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        if (password.trim().equals("")) {
            this.password = null;

        } else {
            this.password = password.trim();
        }
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        if (type.trim().contains("artist") || type.trim().contains("employee")) {
            this.type = type.trim();

        } else {
            this.type = null;
        }
    }
}