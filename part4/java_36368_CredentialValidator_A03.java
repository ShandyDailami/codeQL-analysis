import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36368_CredentialValidator_A03 {

    // Hashed passwords should be stored in a database
    private static final String[] hashedPasswords = new String[] {
        "$2a$10$E6SqvRvOqUjKlMXZuFYu./Nd.2O63W.J5MX.ZY8.YrTgR7k.MkM2", // password1
        "$2a$10$q4PqjRZr2vN1.9DH2f.eH.WjO.QX2.H.Yqf.D5.GKR4q.Z1.Rv", // password2
        // add more passwords as needed
    };

    public static boolean validate(String providedPassword) {
        try {
            return isValidPassword(providedPassword);
        } catch (Exception e) {
            // handle exception
            return false;
        }
    }

    private static boolean isValidPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpec {
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        byte[] salt = Arrays.copyOfRange(decodedPassword, 0, 8);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        SecretKey key = keyFactory.generateSecret(spec);
        byte[] decodedHashedPassword = Base64.getDecoder().decode(decodedPassword);

        return Arrays.equals(key.getEncoded(), decodedHashedPassword);
    }
}