import javax.security.auth.Credential;
import javax.security.auth.login.LoginException;

public class java_41559_CredentialValidator_A01 {

    private Credential credential;

    public java_41559_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    public String validate(String username, String password) {
        if (this.credential == null) {
            return "Authentication failed due to missing credentials";
        }

        if (!this.credential.getAuthType().equals("username_password")) {
            return "Authentication failed: Wrong authentication type";
        }

        if (!this.credential.getCaller().equals(username)) {
            return "Authentication failed: Incorrect username";
        }

        if (!this.credential.getCallerPrincipal().equals(password)) {
            return "Authentication failed: Incorrect password";
        }

        return "Authentication successful";
    }
}