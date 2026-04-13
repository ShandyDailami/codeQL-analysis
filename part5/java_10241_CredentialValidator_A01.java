public class java_10241_CredentialValidator_A01 {
    // Define a hashmap for storage
    private Map<String, String> userMap;

    public java_10241_CredentialValidator_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the user exists in our map
        if (userMap.containsKey(username)) {
            // Check if the password matches the stored password
            if (userMap.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}