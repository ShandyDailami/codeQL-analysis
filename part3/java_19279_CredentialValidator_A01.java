import java.util.HashMap;
import java.util.Map;

public class java_19279_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_19279_CredentialValidator_A01() {
        // Use a HashMap to simulate a database.
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // Check if the credentials exist in our map.
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}