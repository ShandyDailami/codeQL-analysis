public class java_24027_CredentialValidator_A01 {
    // Create a HashMap to store usernames and passwords
    private Map<String, String> credentials;

    // Constructor
    public java_24027_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("admin", "password");
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Check if username and password are in the map
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Try to validate credentials
        boolean isValid = validator.validateCredentials("admin", "password");
        System.out.println("Is Valid: " + isValid);

        isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is Valid: " + isValid);

        isValid = validator.validateCredentials("user3", "password3");
        System.out.println("Is Valid: " + isValid);
    }
}