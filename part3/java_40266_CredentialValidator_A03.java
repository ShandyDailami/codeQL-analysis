import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_40266_CredentialValidator_A03 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Checking the strength of the password.
            // For now, we will only check the length and see if the password contains at least one digit, one lowercase letter, one uppercase letter, and one special character.
            if (password.length() < 8) {
                return false;
            }

            for (byte b : hash) {
                if (b < 0) { // To avoid negative values.
                    return false;
                }
            }

            return true;
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}