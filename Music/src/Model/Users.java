package Model;

import Control.Config;

/**
 * @author Kaik D' Andrade
 */
public class Users {

    private int id;
    private String name;
    private String login;
    private String password;
    private String type;
    private int avatar;
    private String status;

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

            if (!Config.isLogin(login)) {
                this.login = null;
            }

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
        if (!Config.isPassword(password.trim())) {
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

    /**
     * @return the avatar
     */
    public int getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        if(status.trim().contains("on") || status.trim().contains("del")) {
            this.status = status.trim();
            
        } else {
            this.status = null;
        }
    }
}
