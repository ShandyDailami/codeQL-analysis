public class java_39241_CredentialValidator_A01 {

    // A map of valid users and passwords.
    private Map<String, String> validUsers;

    public java_39241_CredentialValidator_A01() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    // Method to validate the username and password.
    public boolean validateCredentials(String username, String password) {
        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}