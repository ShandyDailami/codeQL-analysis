import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.management.RuntimeErrorException;

public class java_15042_CredentialValidator_A07 {

    private static final String SALT = "salt"; // This should be a secret and unique for each user.
    private static final String SECRET = "secret"; // This should be a secret and unique for each application.

    public static boolean isPasswordStrongEnough(String password) {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), SALT.getBytes(), 10000, 512));
            return true;
        } catch (NoSuchAlgorithmException | InvalidKeySpec e) {
            throw new RuntimeErrorException(e);
        }
    }
}