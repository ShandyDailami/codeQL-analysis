import java.util.HashMap;
import java.util.Map;

public class java_24957_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_24957_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        return this.credentials.containsKey(user) && this.credentials.get(user).equals(password);
    }
}