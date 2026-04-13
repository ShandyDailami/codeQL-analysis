import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_27069_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public String getRequestUsername(UsernamePasswordCredential credential) {
        // This method is called when the CredentialValidator is invoked for a password challenge
        return "user";
    }

    @Override
    public String getPassword(String username, String callingPKCEmitter) throws InvalidCredentialException {
        // This method is called when the CredentialValidator is invoked for a password challenge
        return "password";
    }

    @Override
    public void validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // This method is called when the CredentialValidator is invoked for a password challenge
        if ("user".equals(credential.getUsername()) && "password".equals(credential.getPasswordAsString())) {
            return;
        }

        throw new InvalidCredentialException("Invalid username or password");
    }
}