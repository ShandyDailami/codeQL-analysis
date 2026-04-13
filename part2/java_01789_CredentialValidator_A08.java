import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_01789_CredentialValidator_A08 {

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyPassword(String password, String hash) {
        return hashPassword(password).equals(hash);
    }

    public static void main(String[] args) {
        String password = "myPassword";
        String hash = hashPassword(password);
        System.out.println("Hash: " + hash);

        if (verifyPassword(password, hash)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}