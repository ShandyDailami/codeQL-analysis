import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_06494_SessionManager_A01 {
    private static final String ALGORITHM = "SHA-256";
    private static final int SALT_SIZE = 16;

    private java_06494_SessionManager_A01() {}

    public static String createSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        digest.update(salt.getBytes());
        byte[] bytes = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password";
        String salt = createSalt();
        String hashedPassword = hashPassword(password, salt);

        System.out.println("Password: " + password);
        System.out.println("Salt: " + salt);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}