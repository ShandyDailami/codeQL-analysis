import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_19753_CredentialValidator_A07 {

    private static final String SALT = "salt";

    public boolean validate(String password, String encodedPassword) {
        String hashedPassword = hashPassword(password);
        return hashedPassword.equals(encodedPassword);
    }

    private String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String encodedPassword = Base64.getEncoder().encodeToString(digest.digest(password.getBytes()));
        return encodedPassword;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "password";
        String hashedPassword = validator.hashPassword(password);

        boolean isValid = validator.validate(password, hashedPassword);
        System.out.println("Is Valid: " + isValid);
    }
}