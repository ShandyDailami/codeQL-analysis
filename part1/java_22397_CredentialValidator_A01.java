import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22397_CredentialValidator_A01 {

    // This method encodes a password in a secure manner
    public static String encodePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    // This method validates a password and username against a known good password
    public static boolean validatePassword(String username, String password, String goodPassword) throws NoSuchAlgorithmException {
        String hashedGoodPassword = encodePassword(goodPassword);
        return hashedGoodPassword.equals(encodePassword(password + username));
    }
}