import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.PasswordAuthentication;
import javax.security.auth.login.LoginException;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;

public class java_18857_CredentialValidator_A07 {

    public CredentialValidationResult validate(Credential credential) throws LoginException {
        // Get the username and password from the credential
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // Check if username and password are empty
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return CredentialValidationResult.failed("Username and password cannot be empty");
        }

        // If everything is OK, return successful result
        return CredentialValidationResult.success();
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        UsernamePasswordCredential credential = new UsernamePasswordCredential("username", "password");

        try {
            CredentialValidationResult result = validator.validate(credential);
            if (result.getResult() == CredentialValidationResult.SUCCESS) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed: " + result.getResult());
            }
        } catch (LoginException e) {
            System.out.println("Error while validating credentials: " + e.getMessage());
        }
    }
}