import java.util.HashMap;
import java.util.Map;

public class java_23117_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_23117_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // If the username and password match the stored credentials, return true
        if (this.credentials.get(username).equals(password)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }

    // This is a method to add more credentials
    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate valid credentials
        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }

        // Validate invalid credentials
        if (!validator.validateCredentials("admin", "wrongpassword")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}