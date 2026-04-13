import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_37308_CredentialValidator_A03 {

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    private static final int KEY_LENGTH = 160;
    private static final int ITERATION_COUNT = 65536;
    private static final byte[] SALT = "salt".getBytes();
    private static final Pattern VALID_PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$)");

    public boolean validatePassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), SALT, ITERATION_COUNT));

        return isValid(key);
    }

    private boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

    private boolean isValid(SecretKey key) {
        // Here you can write your own validation logic
        // For simplicity, we just return true in this example
        return true;
    }
}