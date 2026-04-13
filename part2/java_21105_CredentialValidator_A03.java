import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_21105_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws LoginException {
        // Username and password are hardcoded for simplicity.
        // In a real-world application, you'd want to use a more secure method of getting these values.
        String username = "admin";
        String password = "password";

        if (credential.getIdentifier().equals(username) && credential.getPassword().equals(password)) {
            return new UsernamePasswordCredential(username, password, "VALID");
        } else {
            throw new LoginException("Invalid credentials");
        }
    }
}