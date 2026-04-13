import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.message.MessageException;
import javax.security.auth.Credential;

public class java_18502_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_18502_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Credential validate(Credential credential) throws MessageException {
        if (credential.getIdentifier().equals(username)) {
            if (credential.getPassword().equals(password)) {
                return credential;
            }
        }
        throw new PasswordChangeRequiredException("Password is incorrect");
    }

}