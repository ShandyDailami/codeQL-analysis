import java.util.HashMap;
import java.util.Map;

public class java_31869_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_31869_CredentialValidator_A08() {
        // Use a HashMap for storing the credentials
        credentials = new HashMap<>();
        // Add sample credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the ones stored in the map
        if (credentials.get(username).equals(password)) {
            System.out.println("Credentials validated successfully!");
            return true;
        } else {
            System.out.println("Credentials invalid!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the CredentialValidator
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("user1", "password1");
        validator.validateCredentials("user2", "wrongpassword");
        validator.validateCredentials("unknownuser", "password");
    }
}