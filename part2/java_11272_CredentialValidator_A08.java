import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_11272_CredentialValidator_A08 {

    // Define the complexity requirements
    private static final int PASSWORD_MIN_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Define the complexity checker
    private static Pattern pattern;

    public java_11272_CredentialValidator_A08() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        return true;
    }
}