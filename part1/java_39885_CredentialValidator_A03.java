import java.security.Credential;
import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.AccessDeniedException;
import java.security.Guardian;
import java.security.GuardianBroker;

public class java_39885_CredentialValidator_A03 implements CredentialValidator {

    // Define the hard-coded password
    private static final String hardCodedPassword = "password";

    @Override
    public Credential.TokenResult validate(Credential credential) {
        // Get the password from the credential
        String password = credential.getPassword();

        // Check if the password matches the hard-coded password
        if (password.equals(hardCodedPassword)) {
            return Credential.TokenResult.VALID;
        } else {
            return Credential.TokenResult.INVALID;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a custom validator
        CustomValidator customValidator = new CustomValidator();

        // Create a guardian and broker
        Guardian guardian = new Guardian(customValidator);
        GuardianBroker broker = new GuardianBroker(guardian);

        // Test the guardian
        try {
            broker.login("user", "password");
            System.out.println("Access granted");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied");
        }
    }
}