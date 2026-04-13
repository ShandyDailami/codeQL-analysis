import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_42091_CredentialValidator_A01 implements CredentialValidator {

    // This should be a secure method of storing and retrieving credentials
    private Map<String, String> credentials = new HashMap<>();

    public java_42091_CredentialValidator_A01() {
        // Add some dummy credentials for testing
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws BadCredentialsException {
        String presentedPassword = new String(Base64.getDecoder().decode(credential.getCredentials()));

        if (credentials.containsKey(credential.getIdentity())) {
            if (credentials.get(credential.getIdentity()).equals(presentedPassword)) {
                return new CredentialValidationResult(credential.getIdentity(), true);
            } else {
                throw new BadCredentialsException("Incorrect password");
            }
        } else {
            throw new BadCredentialsException("Unknown user");
        }
    }
}