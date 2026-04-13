import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.credential.Credential;

public class java_39329_CredentialValidator_A01 implements CredentialValidator {

    private String myUsername;
    private String myPassword;

    public java_39329_CredentialValidator_A01(String username, String password) {
        this.myUsername = username;
        this.myPassword = password;
    }

    @Override
    public Credential validate(Credential credential) throws InvalidCredentialException {
        String providedUsername = credential.getIdentifier();
        String providedPassword = credential.getCredentialIdentifier();

        if (!myUsername.equals(providedUsername) || !myPassword.equals(providedPassword)) {
            throw new InvalidCredentialException("Invalid username or password");
        }

        return credential;
    }
}