import java.util.HashMap;
import java.util.Map;

public class java_25803_CredentialValidator_A03 {

    // A map to store credentials
    private Map<String, String> credentials;

    public java_25803_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // A method to authenticate a user
    public boolean authenticate(String username, String password) {
        if (this.credentials.containsKey(username)) {
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}