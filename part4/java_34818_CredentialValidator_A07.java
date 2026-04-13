import java.util.HashMap;
import java.util.Map;

public class java_34818_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_34818_CredentialValidator_A07() {
        // Using hardcoded credentials for simplicity
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws AuthenticationFailedException {
        String user = c.getIdentifier();
        String password = c.getCredential();

        if (!credentials.containsKey(user)) {
            throw new AuthenticationFailedException("User not found");
        }

        if (!credentials.get(user).equals(password)) {
            throw new AuthenticationFailedException("Incorrect password");
        }

        return new CredentialValidationResult("User is valid", null);
    }
}