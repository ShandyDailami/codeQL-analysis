import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;
import java.util.Base64;

public class java_34195_CredentialValidator_A03 implements CredentialValidator {

    private Credential credential;

    public java_34195_CredentialValidator_A03() {
        // Initialize your credential here. This could be a username/password combination stored in a database.
        String user = "user";
        String password = "password";
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credential = new UsernamePasswordCredential(user, encodedPassword);
    }

    @Override
    public CredentialValidationResult validate(CredentialContext context) throws CredentialException {
        String password = context.getCredential().getPassword();
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (encodedPassword.equals(credential.getPassword())) {
            return new CredentialValidationResult("OK", null);
        } else {
            return new CredentialValidationResult("Invalid password", null);
        }
    }
}