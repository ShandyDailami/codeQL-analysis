import java.util.HashMap;

public class java_02256_CredentialValidator_A08 {

    private HashMap<String, String> credentials;

    public java_02256_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Initialize the credentials with some dummy data
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the credentials exist and match the provided password
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}