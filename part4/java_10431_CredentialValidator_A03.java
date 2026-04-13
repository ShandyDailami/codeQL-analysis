import javax.naming.AuthenticationException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialNotFoundException;
import javax.security.auth.credential.PasswordCredential;

public class java_10431_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public Credential validate(Subject subject, Credential credential) throws CredentialNotFoundException, LoginException {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String userName = usernamePasswordCredential.getCaller();
            if ("user".equals(userName)) {
                String password = new String(usernamePasswordCredential.getPassword());
                return new PasswordCredential(password);
            }
        }
        throw new AuthenticationException("Invalid username or password");
    }
}