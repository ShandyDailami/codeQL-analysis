import java.util.HashMap;
import java.util.Map;

public class java_27581_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_27581_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        return this.credentials.containsKey(user) && this.credentials.get(user).equals(password);
    }
}