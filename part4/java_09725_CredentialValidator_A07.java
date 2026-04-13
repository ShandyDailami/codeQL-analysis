public class java_09725_CredentialValidator_A07 {

    // Predefined user list.
    private static final List<User> users = Arrays.asList(
            new User("user1", "password1", "User 1"),
            new User("user2", "password2", "User 2"),
            new User("user3", "password3", "User 3"));

    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class to hold user data.
    private static class User {
        private String username;
        private String password;
        private String name;

        public java_09725_CredentialValidator_A07(String username, String password, String name) {
            this.username = username;
            this.password = password;
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getName() {
            return name;
        }
    }
}