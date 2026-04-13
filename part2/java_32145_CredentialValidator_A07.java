import java.util.HashMap;
import java.util.Map;

public class java_32145_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_32145_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }
        return expectedPassword.hashCode() == password.hashCode();
    }
}