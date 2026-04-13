import java.util.HashMap;
import java.util.Map;

public class java_14313_CredentialValidator_A03 {

    private Map<String, String> credentials = new HashMap<>();

    public java_14313_CredentialValidator_A03() {
        // Initialize the credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // If the credentials match
        if (credentials.get(username).equals(password)) {
            System.out.println("Credentials match!");
            return true;
        // If the credentials do not match
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }
}