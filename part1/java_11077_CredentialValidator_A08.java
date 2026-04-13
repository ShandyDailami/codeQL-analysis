import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11077_CredentialValidator_A08 {
    private static final String SALT = "salt"; // Add a unique salt for each user

    // Method to hash the password
    private String hashPassword(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.update(SALT.getBytes()); // Add a unique salt
        byte[] bytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    // Method to validate the password
    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // User credentials
        String password = "userPassword";
        String hashedPassword = validator.hashPassword(password);

        // Validate user password
        boolean isValid = validator.validatePassword(password, hashedPassword);
        System.out.println("Password is valid: " + isValid);
    }
}