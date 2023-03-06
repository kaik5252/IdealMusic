package Control;

import javax.swing.JTextField;
import java.util.regex.Pattern;

/**
 * @author Kaik D' Andrade
 */
public class Config {

    private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,20}$";
    private static final String LOGIN_PATTERN = "^[a-zA-Z0-9#_.]{6,30}$";

    /**
     * Método que retorna se o (treco) é correto
     * 
     * @author Kaik D' Andrade
     * @param textField
     * @param type
     * @return 
     */
    public static boolean isCorrect(JTextField textField, String type) {

        String text = textField.getText().trim();

        switch (text) {
            case "password" -> {
                Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
                return pattern.matcher(text).matches();
            }

            case "login" -> {
                Pattern pattern = Pattern.compile(LOGIN_PATTERN);
                return pattern.matcher(text).matches();
            }

            default -> {
                return false;
            }
        }
    }

    /**
     * Método resposável por retornar se o login é válido
     *
     * @author Kaik D' Andrade
     * @param login
     * @return
     */
    public static boolean isLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        return pattern.matcher(login).matches();
    }

    /**
     * Método resposável por retornar se o login é válido
     *
     * @author Kaik D' Andrade
     * @return
     */
    public static boolean isLogin(javax.swing.JTextField campoLogin) {
        String login = campoLogin.getText();
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        return pattern.matcher(login).matches();
    }

    /**
     * Método responsável por retornar se a senha é válida
     *
     * @author Kaik D' Andrade
     * @param password
     * @return
     */
    public static boolean isPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }

    /**
     * Método responsável por retornare se todos os campos de texto tem conteúdo
     *
     * @author Kaik D' Andrade
     * @param fields
     * @return
     */
    public static boolean verifyTextFields(javax.swing.JTextField... fields) {
        for (javax.swing.JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Método responsável por limpar os campos de texto
     *
     * @author Kaik D' Andrade
     * @param fields
     */
    public static void clearTextFields(javax.swing.JTextField... fields) {
        for (javax.swing.JTextField field : fields) {
            if (!field.getText().equals("")) {
                field.setText("");
            }
        }
    }

    /**
     * Método resposável por abrir um card de um deteminado painel
     *
     * @author Kaik D' Andrade
     * @param panel
     * @param cardName
     */
    public static void openCard(javax.swing.JPanel panel, String cardName) {
        java.awt.CardLayout card = (java.awt.CardLayout) panel.getLayout();
        card.show(panel, cardName);
    }
}
