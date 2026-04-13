import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_03312_SessionManager_A07 {
    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_SIZE = 16;
    private static SecureRandom sr = new SecureRandom();

    // Method to generate random salt
    public static String generateSalt() {
        byte[] salt = new byte[SALT_SIZE];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Method to generate hash
    public static String generateHash(String password, String salt) {
        String saltedPassword = password + salt;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashedPassword = md.digest(saltedPassword.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Method to check the password against a stored hash and salt
    public static boolean isAuthorized(String password, String salt, String storedHash, SessionManager sessionManager) {
        String hashedPassword = sessionManager.generateHash(password, salt);
        return hashedPassword.equals(storedHash);
    }

    // Usage example
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        String password = "password";
        String salt = sessionManager.generateSalt();
        String hash = sessionManager.generateHash(password, salt);

        if (sessionManager.isAuthorized(password, salt, hash, sessionManager)) {
            System.out.println("Access Granted");
        } else {
            System.out.println("Access Denied");
        }
    }
}