import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;

public class java_41038_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public boolean validate(javax.security.auth.Credential cred) throws InvalidCredentialException {
        String username = cred.getIdentifier();
        String password = cred.getCredential();

        // Here you can add your real-world operations to validate the username and password.
        // For example, you can check if the username and password matches a known good user.

        // Assume the username and password are valid for this example.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password.");
        }
    }
}