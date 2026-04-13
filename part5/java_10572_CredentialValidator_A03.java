import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_10572_CredentialValidator_A03 {

    private static final String SALT_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final int SALT_LENGTH = 10;
    private static final String SHA256 = "SHA-256";

    private static String createSalt() {
        SecureRandom sr = new SecureRandom();
        StringBuilder salt = new StringBuilder(SALT_LENGTH);
        for (int i = 0; i < SALT_LENGTH; i++) {
            salt.append(SALT_CHARACTERS.charAt(sr.nextInt(SALT_CHARACTERS.length())));
        }
        return salt.toString();
    }

    private static String createHash(String input, String salt) {
        String saltedInput = salt + input;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(SHA256);
            md.update(saltedInput.getBytes());
            byte[] digest = md.digest();
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String createHashedPassword(String password) {
        String salt = createSalt();
        return createHash(password, salt);
    }

    public static boolean validatePassword(String password, String hashedPassword, String salt) {
        String hashedCheck = createHash(password, salt);
        return hashedCheck.equals(hashedPassword);
    }

    public static void main(String[] args) {
        String password = "test";
        String hashedPassword = createHashedPassword(password);
        String salt = hashedPassword.substring(0, 10);
        System.out.println("Hashed Password: " + hashedPassword);
        System.out.println("Salt: " + salt);

        boolean isValid = validatePassword("test", hashedPassword, salt);
        System.out.println("Is Valid Password: " + isValid);
    }
}