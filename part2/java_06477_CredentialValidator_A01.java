public class java_06477_CredentialValidator_A01 {

    // Predefined users and their passwords
    private static final Map<String, String> users = new HashMap<>();
    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    // Method for validating credentials
    public boolean validateCredentials(String username, String password) {
        // Check if user is in the predefined list
        if (users.containsKey(username)) {
            // Check if password matches
            return users.get(username).equals(password);
        } else {
            // No such user, return false
            return false;
        }
    }
}