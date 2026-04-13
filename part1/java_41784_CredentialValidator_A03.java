import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Credential;

public class java_41784_CredentialValidator_A03 implements CredentialValidator {

    // Hard-coded credentials
    private final String usernameHardCoded = "admin";
    private final String passwordHardCoded = "password";

    @Override
    public Credential validate(Credential c) throws InvalidCredentialException {
        String userName = c.getCredentialIdentifier();
        String password = c.getCredential();

        // Compare input with hard-coded set
        if (!userName.equals(usernameHardCoded) || !password.equals(passwordHardCoded)) {
            throw new InvalidCredentialException("Invalid username or password");
        }

        // Return the Credential object if validation was successful
        return c;
    }
}