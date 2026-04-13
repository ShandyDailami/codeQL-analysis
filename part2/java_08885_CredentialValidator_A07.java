import java.util.HashMap;
import java.util.Map;

public class java_08885_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_08885_CredentialValidator_A07() {
        // A simple in-memory storage for credentials
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the stored ones
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to authenticate with valid credentials
        validator.validateCredentials("admin", "password");
        
        // Try to authenticate with invalid credentials
        validator.validateCredentials("admin", "wrong_password");
    }
}