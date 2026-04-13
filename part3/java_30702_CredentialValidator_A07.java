import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class java_30702_CredentialValidator_A07 {
    private static final SecureRandom random = new SecureRandom();

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifyPassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        PasswordCredentialValidator validator = new PasswordCredentialValidator();

        String password = validator.generateRandomPassword(10);
        System.out.println("Generated password: " + password);

        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = validator.verifyPassword(password, hashedPassword);
        System.out.println("Is valid password: " + isValid);
    }
}