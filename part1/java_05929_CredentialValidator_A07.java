import java.util.HashMap;

public class java_05929_CredentialValidator_A07 {
    private HashMap<String, String> credentials;

    public java_05929_CredentialValidator_A07() {
        credentials = new HashMap<>();
        // Add some default credentials (You may use any hardcoded data)
        credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the given credentials are correct
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}