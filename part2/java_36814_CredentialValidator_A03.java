import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_36814_CredentialValidator_A03 {

    private static final Pattern passwordPattern;

    static {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        passwordPattern = Pattern.compile(pattern);
    }

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = passwordPattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Arrays.equals(hash, md.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}