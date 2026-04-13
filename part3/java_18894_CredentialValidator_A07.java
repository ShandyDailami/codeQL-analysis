import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_18894_CredentialValidator_A07 implements javax.security.auth.credential.CredentialValidator {

    @Override
    public Credential validate(Credential credential) throws CredentialException, LoginException {
        String username = credential.getCaller();
        String password = credential.getPassword();

        if (password.length() >= 8) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new CredentialException("Password must be at least 8 characters long");
        }
    }
}