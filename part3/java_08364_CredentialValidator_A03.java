import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_08364_CredentialValidator_A03 {

    private static final Pattern passwordPattern;
    private static final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,15}$";

    static {
        passwordPattern = Pattern.compile(passwordRegex);
    }

    public static boolean validatePassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String testPassword1 = "test";
        String testPassword2 = "Test12345!";

        System.out.println(testPassword1 + " is valid: " + validatePassword(testPassword1));
        System.out.println(testPassword2 + " is valid: " + validatePassword(testPassword2));
    }
}