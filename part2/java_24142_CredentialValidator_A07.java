public class java_24142_CredentialValidator_A07 {

    // Define the list of allowed users
    private static final List<User> allowedUsers = new ArrayList<>();

    // Initialize the allowed users list
    static {
        allowedUsers.add(new User("user1", "password1"));
        allowedUsers.add(new User("user2", "password2"));
    }

    // CredentialValidator class should not be instantiated
    private java_24142_CredentialValidator_A07() {
        throw new UnsupportedOperationException();
    }

    // Method to validate the credentials
    public static boolean validate(String username, String password) {
        for (User user : allowedUsers) {
            if (user.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    // Helper class to represent a user
    private static class User {
        private final String username;
        private final String password;

        private java_24142_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        private boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}