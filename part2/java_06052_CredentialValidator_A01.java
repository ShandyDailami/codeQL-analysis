import java.util.HashMap;
import java.util.Map;

public class java_06052_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_06052_CredentialValidator_A01() {
        // Initialize the credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Check if the provided password matches the stored password
        return this.credentials.get(username).equals(password);
    }
}