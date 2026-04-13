import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_27014_CredentialValidator_A01 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String testPassword = "Test@1234";
        System.out.println("Is password valid? " + validatePassword(testPassword));
    }
}