import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_25739_CredentialValidator_A01 {

    private MessageDigest messageDigest;

    public java_25739_CredentialValidator_A01() {
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateCredentials(String username, String password, String hashedPassword) {
        // Generate a hash of the password
        byte[] hashedInput = messageDigest.digest(password.getBytes());

        // Compare the hashed input with the hashed password
        return Arrays.equals(hashedInput, Base64.getDecoder().decode(hashedPassword));
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();

        String username = "user";
        String password = "password";
        String hashedPassword = "$argon2id$v=19$m=65536,t=4,p=1$A$21232F..."; // This is a hashed password

        boolean valid = validator.validateCredentials(username, password, hashedPassword);

        System.out.println("Is valid: " + valid);
    }
}