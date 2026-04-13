import java.util.HashMap;
import java.util.Map;

public class java_31841_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_31841_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }

        return expectedPassword.equals(password);
    }
}