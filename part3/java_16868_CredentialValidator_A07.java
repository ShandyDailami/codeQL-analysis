import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_16868_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    public String createEncodedPassword(String password) {
        if (isPasswordStrong(password)) {
            return Base64.getEncoder().encodeToString(password.getBytes());
        } else {
            throw new IllegalArgumentException("Password is not strong enough.");
        }
    }
}