import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_24348_CredentialValidator_A01 implements CredentialValidator {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    public java_24348_CredentialValidator_A01() {
    }

    public Credential validate(Credential credential) throws LoginException {
        if (credential == null) {
            throw new LoginException("Null credentials provided");
        }

        String username = credential.getUsername();
        String password = credential.getPassword();

        if (username == null || password == null) {
            throw new LoginException("Username or password is null");
        }

        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Invalid credentials");
        }
    }
}