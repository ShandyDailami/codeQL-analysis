import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordCredential;

public class java_31783_CredentialValidator_A07 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_31783_CredentialValidator_A07() {
        // Create a map of username and password for validation
        this.credentials = new HashMap<String, String>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public CredentialValidationResult validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String name = credential.getCaller();
        String password = new String(Base64.getDecoder().decode(credential.getPassword()));

        // Check if the provided password matches the stored password
        if (this.credentials.get(name).equals(password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            throw new InvalidCredentialException("Authentication failed.");
        }
    }
}