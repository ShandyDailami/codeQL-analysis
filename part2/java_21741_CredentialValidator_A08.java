import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21741_CredentialValidator_A08 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_21741_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialValidationException {
        String username = credential.getIdentifier();
        String password = new String(Base64.getDecoder().decode(credential.getCredential()));

        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return new CredentialValidationResult(username, true, null);
        } else {
            return new CredentialValidationResult(username, false, "Incorrect username or password");
        }
    }
}