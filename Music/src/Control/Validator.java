package Control;

//import java.util.regex.Pattern;
//
///**
// * @author Kaik D' Andrade
// */
//public class Validator {
//
//    private static final Pattern EMAILPATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$");
//    private static final Pattern PASSWORDPATTERN = Pattern.compile("(?=.*[0-9].*[0-9].*[0-9].*[0-9])(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z])(?=.*[#&_\\-\\.\\*]).{12,}");
//
//    private static boolean isEmail(String email) {
//        return EMAILPATTERN.matcher(email).matches();
//    }
//
//    private static boolean isPassword(String password) {
//        return PASSWORDPATTERN.matcher(password).matches();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(isPassword("#abcd1234")); // true
//        System.out.println(isPassword("#1234abcd")); // true
//        System.out.println(isPassword("abcd#1234")); // true
//        System.out.println(isPassword("abcd")); // false
//        System.out.println(isPassword("1234")); // false
//        System.out.println(isPassword("abcd1234")); // false
//        System.out.println(isPassword("#abcd1234")); // false
//    }
//}
import java.util.regex.Pattern;

public class PasswordValidator {
  private static final Pattern passwordPattern = Pattern.compile("(?=.*[0-9].*[0-9].*[0-9].*[0-9])(?=.*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z])(?=.*[#_-.&*]).{8,20}");

  public static boolean isValid(String password) {
    return passwordPattern.matcher(password).matches();
  }

  public static void main(String[] args) {
    System.out.println(isValid("abcd1234#")); // true
    System.out.println(isValid("1234abcd&")); // true
    System.out.println(isValid("abcd_-1234")); // true
    System.out.println(isValid("abcd")); // false
    System.out.println(isValid("1234")); // false
    System.out.println(isValid("abcd1234")); // false
    System.out.println(isValid("#abcd1234")); // false
    System.out.println(isValid("abcdefghijklmnopqrstuvwxyz")); // false
    System.out.println(isValid("012345678901234567890")); // false
  }
}

