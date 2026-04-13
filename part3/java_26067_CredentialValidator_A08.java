import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_26067_CredentialValidator_A08 {

    private static final Pattern passwordPattern;

    static {
        String patternString = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        passwordPattern = Pattern.compile(patternString);
    }

    public static boolean isPasswordValid(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String password = "ThisIsAWeakPassword";
        if (isPasswordValid(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }
}