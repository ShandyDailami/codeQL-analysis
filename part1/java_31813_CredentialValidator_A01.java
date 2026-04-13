import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_31813_CredentialValidator_A01 {

    private static final String SECRET = "super-secure-passphrase";
    private static final String SALT = "salt-from-traditional-store-of-passphrase";
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 20000;
    private static final int KEY_LENGTH = 256;

    public boolean validate(String passwordAttempt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey key = factory.parseSecret(SECRET, null);

        byte[] actual = key.getEncoded();

        SecretKeyFactory factory2 = SecretKeyFactory.getInstance(ALGORITHM);
        byte[] encoded = factory2.parseSecret(SALT, null).getEncoded();

        PBEKeySpec spec = new PBEKeySpec(passwordAttempt.toCharArray(), encoded, ITERATIONS, KEY_LENGTH);
        SecretKey keyFromSpec = factory.generateSecret(spec);

        byte[] rawKey = keyFromSpec.getEncoded();

        return Base64.getEncoder().encodeToString(rawKey).equals(Base64.getEncoder().encodeToString(actual));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("correct-password")); // Should print true
        System.out.println(validator.validate("wrong-password")); // Should print false
    }
}