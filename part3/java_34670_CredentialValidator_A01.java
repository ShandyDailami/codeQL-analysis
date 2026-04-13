import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_34670_CredentialValidator_A01 {
    private static final String SECRET = "mySecret"; // This should be kept secret
    private static final String SALT = "mySalt"; // This should be kept secret
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256"; // This should be kept secret

    public boolean validate(String passwordAttempt) throws NoSuchAlgorithmException, InvalidKeySpec {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
            SecretKey key = factory.createSecret(new PBEKeySpec(SECRET.toCharArray(), SALT.getBytes(), 20000, 256));
            byte[] decodedPassword = Base64.getDecoder().decode(passwordAttempt);
            byte[] checkedPassword = key.getEncoded();

            return javax.crypto.Cipher.getInstance("AES").doFinal(decodedPassword, 0, decodedPassword.length, checkedPassword, 0);
        } catch (Exception e) {
            return false;
        }
    }
}