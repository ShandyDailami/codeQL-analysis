import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialNotFoundException;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractLoginModule;

public class java_39021_CredentialValidator_A01 extends AbstractLoginModule {

    // In a real application, these would come from a database or some other source.
    private Map<String, String> credentials = new HashMap<>();

    public java_39021_CredentialValidator_A01() {
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate( javax.security.auth.Credential credential ) throws InvalidCredentialException, CredentialNotFoundException, LoginException {
        String id = credential.getIdentifier();
        String password = credential.getCredential();

        if (this.credentials.containsKey(id)) {
            if (this.credentials.get(id).equals(password)) {
                return new CredentialValidationResult("Credentials are correct", "USER", null);
            } else {
                return new CredentialValidationResult("Invalid password", "USER", null);
            }
        } else {
            return new CredentialValidationResult("User not found", "USER", null);
        }
    }
}