import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36960_CredentialValidator_A03 {

    private Map<String, String> credentialStore;

    public java_36960_CredentialValidator_A03() {
        credentialStore = new HashMap<>();
        // Add some dummy credentials for testing
        credentialStore.put("user1", "password1");
        credentialStore.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = credentialStore.get(username);
        if (expectedPassword == null) {
            return false;
        }

        String expectedPasswordBase64 = new String(Base64.getEncoder().encode(expectedPassword.getBytes()));
        String providedPasswordBase64 = new String(Base64.getEncoder().encode(password.getBytes()));

        return expectedPasswordBase64.equals(providedPasswordBase64);
    }
}