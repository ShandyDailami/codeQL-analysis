import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;

public class java_33250_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    public java_33250_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordAuthentication validate(PasswordAuthentication authentication) {
        String username = authentication.getIdentifier();
        String password = new String(authentication.getCredentials());

        if (this.username.equals(username) && this.password.equals(password)) {
            return null; // Successful authentication
        } else {
            return new PasswordAuthentication.Destroyed(authentication); // Authentication failed
        }
    }
}