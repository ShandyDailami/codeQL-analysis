import javax.security.auth.login.LoginException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialInvalidException;
import javax.security.auth.UsernamePasswordCredential;

public class java_12218_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws CredentialInvalidException {
        if (credential.getIdentifier().equals(username) && credential.getPassword().equals(password)) {
            return credential;
        } else {
            throw new CredentialInvalidException("Invalid username or password");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}