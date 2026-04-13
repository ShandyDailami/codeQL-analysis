import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_06348_CredentialValidator_A01 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // This is a very basic validation. In a real-world scenario, you'd probably want to use a more complex validation logic.
        if ("admin".equals(credential.getUsername()) && "password".equals(credential.getPassword())) {
            return credential;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }

}