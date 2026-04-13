import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_04928_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_04928_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        String expectedPassword = this.credentials.get(username);
        String actualPassword = Base64.getEncoder().encodeToString(password.getBytes());

        return expectedPassword.equals(actualPassword);
    }
}