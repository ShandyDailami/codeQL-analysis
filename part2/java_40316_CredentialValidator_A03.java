import java.util.HashMap;
import java.util.Map;

public class java_40316_CredentialValidator_A03 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_40316_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    @Override
    public CredentialValidationResult validate(Credential c) {
        String username = c.getIdentifier();
        String password = c.getCredential();

        // Check if the password matches the expected password
        if (this.credentials.get(username).equals(password)) {
            return new CredentialValidationResult(username, "Success", null);
        } else {
            return new CredentialValidationResult(username, "Invalid password", null);
        }
    }
}