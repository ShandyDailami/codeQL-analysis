import java.util.HashMap;
import java.util.Map;

public class java_10488_CredentialValidator_A07 {

    // Map to store username and password
    private Map<String, String> credentials;

    public java_10488_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        // Add some default credentials for testing
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing valid credentials
        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        // Testing invalid credentials
        if (!validator.validate("user3", "wrongpassword")) {
            System.out.println("Access granted for user3");
        } else {
            System.out.println("Access denied for user3");
        }
    }
}