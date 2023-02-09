package Control;

import java.util.regex.Pattern;

/**
 * @author Kaik D' Andrade
 */
public class Validator {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]{6,}+@[a-zA-Z0-9]{3,}+.[a-zA-Z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,20}$";

    private static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

    private static boolean isPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }
}