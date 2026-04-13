public class java_37147_CredentialValidator_A07 {
    // Define a data structure for storing credential details
    private static class Credential {
        private String username;
        private String password;

        public java_37147_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // Define a list of stored credentials
    private List<Credential> storedCredentials = new ArrayList<>();

    // Constructor
    public java_37147_CredentialValidator_A07() {
        storedCredentials.add(new Credential("user1", "password1"));
        storedCredentials.add(new Credential("user2", "password2"));
    }

    // Method for authenticating a user
    public boolean authenticate(String username, String password) {
        // Iterate over the stored credentials
        for (Credential credential : storedCredentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                // Authentication successful, return true
                return true;
            }
        }

        // Authentication failed, return false
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Authenticate with valid credentials
        if (validator.authenticate("user1", "password1")) {
            System.out.println("Authentication successful for user1.");
        } else {
            System.out.println("Authentication failed for user1.");
        }

        // Authenticate with invalid credentials
        if (!validator.authenticate("user3", "wrongpassword")) {
            System.out.println("Authentication successful for user3.");
        } else {
            System.out.println("Authentication failed for user3.");
        }
    }
}