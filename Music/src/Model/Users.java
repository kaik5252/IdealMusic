package Model;

import Control.Validator;

/**
 * @author Kaik D' Andrade
 */
public class Users {

    private String name;
    private String login;
    private String password;

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

            if (!Validator.isLogin(login)) {
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
        if (password.trim().equals("")) {
            this.password = null;

        } else {

            if (!Validator.isPassword(password)) {
                this.password = null;
            }

            this.password = password.trim();
        }
    }
}