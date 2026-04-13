import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpec;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class java_22145_CredentialValidator_A08 {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpec {
        String password = "password123"; // This could be a hard-coded password
        String encryptedPassword = encryptPassword(password);

        if (validatePassword(password, encryptedPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    private static String encryptPassword(String password) throws NoSuchAlgorithmException {
        // This is a simplistic example. In reality, you should use a stronger key derivation algorithm
        // and store the encrypted key in a secure manner.
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), "salt".getBytes(), 65536, 512));
        return Base64.getEncoder().encodeToString(Hex.encode(key.getEncoded()));
    }

    private static boolean validatePassword(String password, String encryptedPassword) {
        try {
            String decodedEncryptedPassword = new String(Base64.getDecoder().decode(encryptedPassword));
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            SecretKey key = factory.generateSecret(new PBEKeySpec(password.toCharArray(), "salt".getBytes(), 65536, 512));
            return new String(Hex.decode(decodedEncryptedPassword)).equals(Base64.getEncoder().encodeToString(key.getEncoded()));
        } catch (Exception e) {
            return false;
        }
    }
}