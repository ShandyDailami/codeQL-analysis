import java.util.HashMap;
import java.util.Map;

public class java_28388_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_28388_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some example credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    @Override
    public String getUsername(Credential c) {
        return c.getIdentifier();
    }

    @Override
    public String getPassword(Credential c) {
        return this.credentials.get(c.getIdentifier());
    }

    @Override
    public void validate(Credential c) throws AuthenticationFailedException {
        if (!this.credentials.containsKey(c.getIdentifier()) ||
                !this.credentials.get(c.getIdentifier()).equals(c.getCredential())) {
            throw new AuthenticationFailedException("Authentication failed!");
        }
    }

    @Override
    public boolean supports(Credential c) {
        return true;
    }
}