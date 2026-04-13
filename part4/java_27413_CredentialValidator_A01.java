public class java_27413_CredentialValidator_A01 {

    // Assume we have a method that gets the user's credentials and returns a User object.
    private User getUser(String username) {
        // Implementation here
        return null;
    }

    public boolean validate(String username, String password) {
        // Assume the getUser method returns a non-null value.
        User user = getUser(username);
        if (user == null) {
            // User not found.
            return false;
        }
        // User found, now check the password.
        // In real world, use a hashing algorithm like BCrypt to securely store passwords.
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}