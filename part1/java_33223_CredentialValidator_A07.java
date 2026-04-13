import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33223_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentialStore;

    public java_33223_CredentialValidator_A07() {
        credentialStore = new HashMap<>();

        // Add default credentials
        credentialStore.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialStore.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String presentedPassword = credential.getPassword();
        String expectedPassword = credentialStore.get(credential.getIdentity());

        if (expectedPassword == null) {
            throw new InvalidCredentialException("Unknown user");
        }

        if (!Base64.getDecoder().decode(expectedPassword).equals(presentedPassword)) {
            throw new InvalidCredentialException("Invalid password");
        }

        return CredentialValidationResult.success();
    }
}