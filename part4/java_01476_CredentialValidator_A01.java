import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_01476_CredentialValidator_A01 implements CredentialValidator {
    private Map<String, String> credentialData = new HashMap<>();

    public java_01476_CredentialValidator_A01() {
        credentialData.put("alice", Base64.getEncoder().encodeToString("alice:password".getBytes()));
        credentialData.put("bob", Base64.getEncoder().encodeToString("bob:password".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String presentedPassword = new String(credential.getPassword());

        if (credentialData.containsKey(credential.getIdentifier())) {
            String expectedPassword = credentialData.get(credential.getIdentifier());

            if (expectedPassword.equals(presentedPassword)) {
                return new CredentialValidationResult(true, "Successful authentication.");
            } else {
                return new CredentialValidationResult(false, "Password incorrect.");
            }
        } else {
            return new CredentialValidationResult(false, "User not found.");
        }
    }
}