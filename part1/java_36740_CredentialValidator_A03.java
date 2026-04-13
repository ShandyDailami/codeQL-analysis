import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_36740_CredentialValidator_A03 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            return false;
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));

            return true;
        } catch (NoSuchAlgorithmException | java.lang.StringIndexOutOfBoundsException e) {
            return false;
        }
    }
}