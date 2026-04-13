import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_08898_CredentialValidator_A03 {
    private static final String SALT_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final int SALT_LENGTH = 10;

    public String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Exception found: " + e);
        }
    }

    public String createSalt() {
        StringBuilder sb = new StringBuilder(SALT_LENGTH);
        for (int i = 0; i < SALT_LENGTH; i++) {
            sb.append(SALT_CHARACTERS.charAt(SecureRandom.getInstance().nextInt(SALT_CHARACTERS.length())));
        }
        return sb.toString();
    }

    public boolean validatePassword(String password, String salt, String hashedPassword) {
        return hashPassword(password, salt).equals(hashedPassword);
    }

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        String password = "securePassword";
        String salt = validator.createSalt();
        String hashedPassword = validator.hashPassword(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = validator.validatePassword(password, salt, hashedPassword);
        System.out.println("Is valid: " + isValid);
    }
}