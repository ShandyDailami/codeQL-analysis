import javax.security.auth.CredentialException;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_15360_CredentialValidator_A08 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) throws LoginException, CredentialException {
        UsernamePasswordCredential credential = new UsernamePasswordCredential(username, password);
        return authenticate(credential);
    }

    private boolean authenticate(UsernamePasswordCredential credential) throws LoginException, CredentialException {
        return USERNAME.equals(credential.getCaller()) && PASSWORD.equals(credential.getPasswordAsString());
    }
}