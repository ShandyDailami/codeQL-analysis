import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32071_CredentialValidator_A01 {

    private Map<String, String> credentialStore;

    public java_32071_CredentialValidator_A01() {
        this.credentialStore = new HashMap<>();
        // Fill the credential store with some dummy data.
        credentialStore.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialStore.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) throws InvalidParameterException {
        if (user == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String storedPassword = credentialStore.get(user);

        // Check if the password matches.
        return encodedPassword.equals(storedPassword);
    }
}