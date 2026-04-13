import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class java_08717_CredentialValidator_A07 {

    private static final String SALT = "salt";
    private static final String SECRET = "secret";
    private static final int ITERATIONS = 20000;
    private static final int KEY_LENGTH = 128;

    public boolean validate(String passwordAttempt) throws NoSuchAlgorithmException, InvalidKeySpec {
        byte[] salt = SALT.getBytes();
        byte[] hash = getKey(passwordAttempt, SALT);
        byte[] test = getKey(passwordAttempt, SALT);

        // Compare the stored hash and the new hash
        // Test hash equals to new hash (stored hash is not new hash)
        return Arrays.equals(hash, test);
    }

    private byte[] getKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpec {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeyKeySpec keySpec = new KeyKeySpec(password.toCharArray(), salt, "PBKDF2WithHmacSHA1");
        SecretKey temp = factory.generateSecret(keySpec);
        return temp.getEncoded();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        CredentialValidator validator = new CredentialValidator();
        String passwordAttempt = "password";

        if (validator.validate(passwordAttempt)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}