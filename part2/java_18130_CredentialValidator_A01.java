import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.Credential;

public class java_18130_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) throws LoginException {
        String enteredPassword = credential.getCredentialIdentifier();
        String expectedPassword = "expectedPassword"; // This should be a real hashed password, not a plaintext password

        if (enteredPassword.equals(expectedPassword)) {
            return true;
        } else {
            throw new LoginException("Invalid password");
        }
    }
}