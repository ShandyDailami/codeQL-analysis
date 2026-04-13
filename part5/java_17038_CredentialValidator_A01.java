public class java_17038_CredentialValidator_A01 {

    // A map of valid users and their passwords
    private Map<String, String> validUsers = new HashMap<>();

    // Constructor, initialize valid users
    public java_17038_CredentialValidator_A01() {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    // Method to validate a username and password
    public boolean validateCredentials(String username, String password) {
        // Check if the provided password matches the expected password for the user
        return password.equals(validUsers.get(username));
    }
}