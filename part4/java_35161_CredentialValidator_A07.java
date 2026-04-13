import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class java_35161_CredentialValidator_A07 {

    private static final String SECRET = "mySecret";
    private static final String SALT = "mySalt";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        String password = "password123"; // Password for authentication

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), SALT.getBytes(), 5000, 512));

        // Compare the hashed password with the stored hash
        if (arePasswordsEqual(key, getHashedPassword(password, SALT))) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }

    private static String getHashedPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpec {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), salt.getBytes(), 5000, 512));
        return new String(key.getEncoded());
    }

    private static boolean arePasswordsEqual(SecretKey key1, String key2) throws NoSuchAlgorithmException, InvalidKeySpec {
        return arePasswordsEqual(key1, getHashedPassword(key2, SALT));
    }

    private static boolean arePasswordsEqual(SecretKey key1, String key2) throws NoSuchAlgorithmException, InvalidKeySpec {
        return key1.equals(key2);
    }
}