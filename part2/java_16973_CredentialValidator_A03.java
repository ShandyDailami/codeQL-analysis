import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class java_16973_CredentialValidator_A03 {

    private static final String SECRET = "my-secret-key";
    private static final String SALT = "my-salt";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    public static SecretKey createKey() throws NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                .createKey(SALT.getBytes(StandardCharsets.UTF_8), SECRET.getBytes(StandardCharsets.UTF_8), ITERATIONS, KEY_LENGTH);
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKey key = createKey();
        byte[] hash = key.getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean validatePassword(String passwordToCheck, String hashedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] actualHash = hashPassword(passwordToCheck).getBytes(StandardCharsets.UTF_8);
        return Arrays.equals(actualHash, Base64.getDecoder().decode(hashedPassword));
    }
}