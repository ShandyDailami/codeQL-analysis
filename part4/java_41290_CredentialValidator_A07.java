public class java_41290_CredentialValidator_A07 {
    // A hash map to hold valid credentials
    private Map<String, String> validCredentials;

    // Constructor
    public java_41290_CredentialValidator_A07() {
        validCredentials = new HashMap<>();
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        validCredentials.put("user3", "password3");
    }

    // Method to validate username and password
    public boolean validateCredentials(String username, String password) {
        // Check if the username and password are in the map
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}