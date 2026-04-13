import java.util.HashMap;
import java.util.Map;

public class java_30829_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_30829_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // This is a very basic check. In a real application, you would want to use more secure methods for validation.
        // Also, it's important to not store passwords in plain text.
        return this.credentials.get(username).equals(password);
    }
}