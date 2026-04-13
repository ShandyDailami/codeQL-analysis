import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

public class java_13651_CredentialValidator_A08 {

    private static final String PBKDF2_ALGORITHM = "PBKDF2withSHA256";
    private static final int PBKDF2_KEY_LENGTH = 256;

    private static String hash(String password, byte[] salt) throws NoSuchAlgorithmException {
        return Hex.encodeHexString(org.mindrot.jbcrypt.BCrypt.hash(password, salt));
    }

    public static SecretKey deriveKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKey originalKey = new SecretKeySpec(salt, PBKDF2_ALGORITHM);
        SecretKey derivedKey = new SecretKeySpec(PBKDF2(password, originalKey, PBKDF2_KEY_LENGTH));
        return derivedKey;
    }

    private static byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private static byte[] PBKDF2(String password, SecretKey salt, int bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return PBKDF2PasswordHasher.pbkdf2(password, salt, 10000, bytes);
    }

    public static boolean validate(String password, String hash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return org.mindrot.jbcrypt.BCrypt.checkpw(password, hash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = generateSalt();
        String hashedPassword = hash("password", salt);
        SecretKey key = deriveKey("password", salt.toString());
        boolean isValid = validate("password", hashedPassword);
        System.out.println("Is valid: " + isValid);
    }
}