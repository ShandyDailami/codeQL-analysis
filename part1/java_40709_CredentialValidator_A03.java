import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.login.LoginException;

public class java_40709_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_40709_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialException {
        CredentialValidationResult result = new CredentialValidationResult();

        String username = credential.getID();
        String password = new String(credential.getCredentialIdentifier(), "UTF-8");

        // Check if the username and password are in the map
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            result.setAuthenticated(true);
        } else {
            result.setAuthenticated(false);
        }

        return result;
    }

    public void addCredential(String username, String password) {
        // Use a secure way to store passwords (e.g., using the Bcrypt algorithm)
        // This is just a placeholder, actual implementation will depend on the specific requirements of your application
        password = new String(Base64.getEncoder().encode(password.getBytes()), "UTF-8");
        this.credentials.put(username, password);
    }
}