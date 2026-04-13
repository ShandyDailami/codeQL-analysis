import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_14615_CredentialValidator_A08 {
    public static void main(String[] args) {
        String password = "YourPassword";
        System.out.println(validatePassword(password));
    }

    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialChars = false;

        Pattern pattern;

        if (password.length() > 8) {
            pattern = Pattern.compile("[A-Z]");
            Matcher matcher = pattern.matcher(password);
            upperCase = matcher.find();
        }

        if (password.length() > 8) {
            pattern = Pattern.compile("[a-z]");
            Matcher matcher = pattern.matcher(password);
            lowerCase = matcher.find();
        }

        if (password.length() > 8) {
            pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(password);
            digit = matcher.find();
        }

        if (password.length() > 8) {
            pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(password);
            specialChars = matcher.find();
        }

        return upperCase && lowerCase && digit && specialChars;
    }
}