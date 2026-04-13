import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_28022_CredentialValidator_A03 {

    private static final Pattern PASSWORD_PATTERN;

    static {
        String passwordPolicy = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        PASSWORD_PATTERN = Pattern.compile(passwordPolicy);
    }

    public boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}