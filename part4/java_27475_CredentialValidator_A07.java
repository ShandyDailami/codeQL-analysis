import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.login.LoginException;

public class java_27475_CredentialValidator_A07 implements CredentialValidator {
    private String hardCodedPassword = "password";

    @Override
    public boolean validate(Credential credential) throws CredentialException, LoginException {
        String providedPassword = credential.getCredentialIdentifier();
        if (hardCodedPassword.equals(providedPassword)) {
            return true;
        } else {
            throw new LoginException("Invalid password");
        }
    }
}