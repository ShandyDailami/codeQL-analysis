import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_36546_CredentialValidator_A03 implements CredentialValidator {

    // Define the predefined credentials
    private String username = "admin";
    private String password = "password";

    // Method to validate the credentials
    @Override
    public CredentialValidationResult validate(PasswordAuthentication authentication) {
        String username = authentication.getCaller();
        char[] password = authentication.getPassword();

        // Check if the provided username and password match the predefined credentials
        if (this.username.equals(username) && this.password.equals(new String(password))) {
            // If they match, return a successful validation result
            return new CredentialValidationResult("Success", null);
        } else {
            // If they don't match, return a failed validation result
            return new CredentialValidationResult("Failed", null);
        }
    }
}