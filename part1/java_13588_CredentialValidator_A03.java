import java.util.HashMap;
import java.util.Map;

public class java_13588_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_13588_CredentialValidator_A03() {
        // Use a HashMap for storing credentials
        // This is a placeholder and not a real credential system
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean isValid(String username, String password) {
        // Check if the username and password match the stored credentials
        // If they do, return true, otherwise return false
        return this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        // Create a new CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Try to validate the credentials "admin" and "password"
        if (validator.isValid("admin", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}