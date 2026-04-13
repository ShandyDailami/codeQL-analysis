import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_35479_CredentialValidator_A01 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password"; // User's password
        String salt = generateSalt(); // Generate a unique salt for the password

        System.out.println("Salt: " + salt);
        System.out.println("Password Hash: " + hashPassword(password, salt));
    }

    // Generate a unique salt for the password
    private static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash a password using a unique salt
    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1"); // Use SHA-1 for hashing
        md.update(salt.getBytes());
        byte[] bytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }
}