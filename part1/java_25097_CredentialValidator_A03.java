import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25097_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_25097_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }

        String expectedPasswordBase64 = Base64.getEncoder().encodeToString(expectedPassword.getBytes());
        String providedPasswordBase64 = Base64.getEncoder().encodeToString(password.getBytes());

        return expectedPasswordBase64.equals(providedPasswordBase64);
    }
}