import javax.security.auth.Subject;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.UnavailablePasswordException;
import javax.security.auth.login.CredentialException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.PasswordCredential;
import java.security.Guard;

public class java_17496_CredentialValidator_A08 implements javax.security.auth.CredentialValidator {

    private String username;
    private String password;

    public java_17496_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordCredential validate(PasswordState arg0) throws CredentialException, UnavailablePasswordException {
        if (arg0.getIdentifier().equals(username) && arg0.getPassword().equals(password)) {
            return new PasswordCredential(arg0.getIdentifier(), arg0.getPassword());
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }

    @Override
    public Subject getSubject(PasswordState arg0) throws CredentialException, UnavailablePasswordException {
        return null;
    }

    @Override
    public void refresh(PasswordState arg0) throws UnavailablePasswordException, CredentialException {
    }

    @Override
    public PasswordCredential getPassword(String arg0) throws UnavailablePasswordException, CredentialException {
        return null;
    }

    @Override
    public boolean isValid(PasswordState arg0, String arg1) throws UnavailablePasswordException, CredentialException {
        return false;
    }
}