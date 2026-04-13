import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_37386_CredentialValidator_A08 {

    private final MessageDigest md;
    private final SecureRandom sr;

    public java_37386_CredentialValidator_A08() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("SHA-256");
        sr = new SecureRandom();
    }

    public String hashPassword(String password) {
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return new String(hashedPassword);
    }

    public boolean validateCredentials(String passwordAttempt, String hashedPassword) {
        return hashedPassword.equals(hashPassword(passwordAttempt));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        String password = "password";
        String hashedPassword = validator.hashPassword(password);

        System.out.println("Hashed password: " + hashedPassword);

        String passwordAttempt = "wrongpassword";
        System.out.println("Valid: " + validator.validateCredentials(passwordAttempt, hashedPassword));

        passwordAttempt = password;
        System.out.println("Valid: " + validator.validateCredentials(passwordAttempt, hashedPassword));
    }
}