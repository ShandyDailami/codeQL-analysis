import java.security.InvalidParameterException;
import java.util.Base64;

public class java_23779_CredentialValidator_A07 {

    public boolean validate(String userName, String password) {
        // This is a simple example. In reality, you would need to hash and salt passwords,
        // check against a database, and potentially include other fields.

        // For the sake of simplicity, we'll assume a user named "admin" with password "password"
        if (userName.equals("admin") && password.equals("password")) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        // Test the validator
        CredentialValidator validator = new CredentialValidator();
        try {
            validator.validate("admin", "password");
            System.out.println("Credentials validated successfully");
        } catch (InvalidParameterException e) {
            System.out.println("Failed to validate credentials: " + e.getMessage());
        }
    }
}