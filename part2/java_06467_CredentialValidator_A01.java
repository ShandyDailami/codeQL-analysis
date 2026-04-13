import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialProvider;
import javax.security.auth.credential.UsernamePasswordCredential;
import java.security.InvalidParameterException;

public class java_06467_CredentialValidator_A01 implements CredentialProvider {

    // This is a dummy password. In real-world scenario, the password would be securely stored.
    private static final String DUMMY_PASSWORD = "password";

    @Override
    public Credential validate(Credential credential) throws InvalidParameterException {
        // Validate the username and password.
        String user = credential.getPassword();
        String pass = DUMMY_PASSWORD;

        if (user != null && pass != null) {
            if (user.equalsIgnoreCase(pass)) {
                // If the username and password match, return a valid credential.
                return new UsernamePasswordCredential(user, pass);
            }
        }

        // If the username and password do not match, return null.
        return null;
    }

    @Override
    public void refresh() {
        // This method is not used in this example.
    }
}