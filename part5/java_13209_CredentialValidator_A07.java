public class java_13209_CredentialValidator_A07 {
    // A map of users and their passwords. This is a very simple example.
    private Map<String, String> userMap = new HashMap<>();

    public java_13209_CredentialValidator_A07() {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    // This is the method that will be called by the authenticator
    public boolean validate(String username, String password) {
        // Check if the submitted password matches the stored password.
        // This is a very basic example and should not be used in a real-world application.
        if (password.equals(userMap.get(username))) {
            return true;
        } else {
            return false;
        }
    }
}