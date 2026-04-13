import javax.security.auth.Credential;
import javax.security.auth.FailedAuthenticationException;
import javax.security.auth.login.LoginException;

public class java_16177_CredentialValidator_A07 implements CredentialValidator {

    private String username;
    private String password;

    public java_16177_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Credential validate(Credential credential) throws FailedAuthenticationException {
        String user = credential.getIdentifier();
        String pass = credential.getPassword();

        if (this.username.equals(user) && this.password.equals(pass)) {
            return credential;
        } else {
            throw new FailedAuthenticationException("Invalid credentials");
        }
    }
}