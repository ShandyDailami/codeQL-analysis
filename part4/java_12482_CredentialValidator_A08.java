import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.Subject;

public class java_12482_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        String username = usernamePasswordCredential.getCaller();
        String password = new String(usernamePasswordCredential.getPassword());

        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}