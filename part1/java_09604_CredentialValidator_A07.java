import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_09604_CredentialValidator_A07 {

    private Credential credential;

    public java_09604_CredentialValidator_A07(Credential credential) {
        this.credential = credential;
    }

    public void authenticate(String username, String password) throws LoginException, CredentialNotFoundException {
        if (credential.authenticate(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            throw new CredentialNotFoundException("Invalid credentials");
        }
    }
}