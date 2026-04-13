import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_40011_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(Subject subject, Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getIdentifier();
            String password = new String(usernamePasswordCredential.getPassword());

            if ("user".equals(username) && "password".equals(password)) {
                return true;
            }
        }
        return false;
    }
}