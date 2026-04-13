import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_06123_CredentialValidator_A07 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Password does not match the pattern. It must contain at least one number, one uppercase letter, one lowercase letter, and one special character.");
        }

        return true;
    }

    public String encryptPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        byte[] encryptedPassword = Base64.getEncoder().encode(password.getBytes());
        return new String(encryptedPassword);
    }
}