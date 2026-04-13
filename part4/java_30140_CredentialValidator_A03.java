import javax.security.auth.Credential;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_30140_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public Credential validate(Credential c) throws LoginException {
        if (c == null) {
            throw new LoginException("Invalid Credentials");
        }

        String username = c.getIdentifier();
        String password = c.getCredential();

        // Perform some security sensitive operation related to injection
        // For example, check if the password contains a certain string
        if (password.contains("password")) {
            throw new LoginException("Invalid Credentials");
        }

        // If the password does not contain a certain string, return the Credential object
        return c;
    }
}