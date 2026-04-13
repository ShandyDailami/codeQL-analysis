import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04518_CredentialValidator_A01 implements CredentialValidator {
    private Map<String, String> users;

    public java_04518_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("alice:password".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:password".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(Credential credential) throws CredentialValidationException {
        String decodedCredential = new String(Base64.getDecoder().decode(credential.getCredential()));
        String[] credentials = decodedCredential.split(":");
        String username = credentials[0];
        String password = credentials[1];

        String encodedPassword = users.get(username);

        if (encodedPassword != null && encodedPassword.equals(credential.getCredential())) {
            return new CredentialValidationResult(username, true);
        } else {
            return new CredentialValidationResult(username, false);
        }
    }
}