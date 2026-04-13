import java.util.HashMap;
import java.util.Map;

public class java_25138_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_25138_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean isValidCredentials(String user, String password) {
        return (credentials.get(user) != null && credentials.get(user).equals(password));
    }
}