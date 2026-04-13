import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_14637_CredentialValidator_A03 {
    private final MessageDigest digest;

    public java_14637_CredentialValidator_A03() throws NoSuchAlgorithmException {
        this.digest = MessageDigest.getInstance("SHA-256");
    }

    public String hashPassword(String password) {
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public boolean validatePassword(String password, String hashedPassword) {
        return hashPassword(password).equals(hashedPassword);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CredentialValidator validator = new CredentialValidator();

        String password = "myPassword";
        String hashedPassword = validator.hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = validator.validatePassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}