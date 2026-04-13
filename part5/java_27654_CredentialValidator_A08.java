// import necessary libraries
import java.util.HashMap;
import java.util.Map;

public class java_27654_CredentialValidator_A08 {

    // Define a Map to store usernames and passwords
    private Map<String, String> credentials;

    public java_27654_CredentialValidator_A08() {
        // Initialize the credentials Map
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the username exists in the credentials Map
        if (credentials.containsKey(username)) {
            // Check if the password matches the stored password
            if (credentials.get(username).equals(password)) {
                // If the credentials are valid, return true
                return true;
            } else {
                // If the password does not match, return false
                return false;
            }
        } else {
            // If the username does not exist in the credentials Map, return false
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validate method
        boolean isValid = validator.validate("user1", "password1");
        if (isValid) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Validation failed!");
        }
    }
}