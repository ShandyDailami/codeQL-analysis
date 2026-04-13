import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_07119_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        // Checking password requirements
        if (password.length() < 8) {
            return false;
        }

        Pattern pattern;
        Matcher matcher;

        // Checking for uppercase letters
        pattern = Pattern.compile("[A-Z]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        // Checking for lowercase letters
        pattern = Pattern.compile("[a-z]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        // Checking for digits
        pattern = Pattern.compile("[0-9]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        // Checking for special characters
        pattern = Pattern.compile("[!@#$%^&*()_+\-=\\\\{}[]|\\\\:;\"<>,.?\\\\[\\\\\\]\\\\( )]");
        matcher = pattern.matcher(password);
        if (!matcher.find()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String password = "ThisIsAWeakPassword1";
        if (validatePassword(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}