import java.util.HashMap;
import java.util.Map;

public class java_41217_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_41217_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match those in the map
        return this.credentials.containsKey(username) && 
               this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the credentials
        boolean isValid = validator.validateCredentials("user1", "password1");

        if (isValid) {
            System.out.println("Credentials validated successfully!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}