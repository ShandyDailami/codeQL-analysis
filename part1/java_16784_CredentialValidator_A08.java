import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_16784_CredentialValidator_A08 {
    private static final String ALGORITHM = "SHA-256";

    public static void main(String[] args) {
        // Test the validator
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("user", "password"));
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] hash = digest.digest(password.getBytes());

            // Assuming the password is a hexadecimal string, this will be equivalent to the integrity failure
            // A08_IntegrityFailure is not applicable in this case

            return true;
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Unsupported algorithm: " + ALGORITHM);
            return false;
        }
    }
}