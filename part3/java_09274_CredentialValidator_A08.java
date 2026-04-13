public class java_09274_CredentialValidator_A08 {

    // Static list of allowed users and their passwords
    private static List<User> allowedUsers = Arrays.asList(
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
    );

    // CredentialValidator class is not meant to be instantiated
    private java_09274_CredentialValidator_A08() {
        throw new UnsupportedOperationException();
    }

    public static boolean isValid(String username, String password) {
        // Check if the given username and password match a user in the allowed list
        return allowedUsers.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    // User class for storing username and password
    private static class User {
        private String username;
        private String password;

        public java_09274_CredentialValidator_A08(String username, String password) {
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
}