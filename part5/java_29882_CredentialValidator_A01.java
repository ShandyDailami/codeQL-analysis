import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_29882_CredentialValidator_A01 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean validate(String password) {
        if (!passwordMatchesPattern(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return isValid(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean passwordMatchesPattern(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private boolean isValid(byte[] digest) {
        // Here you can add your own rules for password validity
        // This is a placeholder for the implementation
        return true;
    }
}