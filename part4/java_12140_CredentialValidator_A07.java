public class java_12140_CredentialValidator_A07 {
    // Define a hashmap to store username-password pairs
    private Map<String, String> userMap;

    // Constructor
    public java_12140_CredentialValidator_A07() {
        this.userMap = new HashMap<>();
        // Add some dummy users for demonstration
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    // Method to validate the credentials
    public boolean validateCredentials(String username, String password) {
        // If the username and password match a stored username and password in the map, return true
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        }
        // If not, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate valid credentials
        System.out.println(validator.validateCredentials("user1", "password1")); // should print: true
        System.out.println(validator.validateCredentials("user3", "password3")); // should print: false
    }
}