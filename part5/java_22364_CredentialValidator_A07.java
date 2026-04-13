import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_22364_CredentialValidator_A07 {

    public java_22364_CredentialValidator_A07() {
        // Constructor
    }

    public Credential authenticate(String username, String password) throws LoginException {
        if(username.equals("user") && password.equals("password")) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Invalid username or password");
        }
    }
}