public class java_24755_CredentialValidator_A03 {
    // This is just a simple in-memory store for valid users.
    // In a real application, this would be read from a database.
    private static final User[] users = {
        new User("user1", "pass1"),
        new User("user2", "pass2"),
        new User("user3", "pass3"),
    };

    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.matches(username, password)) {
                return true; // Username and password match a known user
            }
        }
        return false; // No known user matches
    }

    // This is a simple user class. In a real application, you would likely have more fields
    // and methods here, such as a hash of the password or an encryption method.
    private static class User {
        private final String username;
        private final String password;

        public java_24755_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}