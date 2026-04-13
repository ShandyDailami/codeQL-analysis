public class java_38805_CredentialValidator_A03 {

    // This is a placeholder for a real database, replace it with actual implementation
    private static UserDatabase userDatabase = new UserDatabase();

    public boolean validateCredentials(String username, String password) {
        User user = userDatabase.getUser(username);

        // Assuming passwords are hashed for security
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // A simple User class
    private class User {
        private String username;
        private String password;

        public java_38805_CredentialValidator_A03(String username, String password) {
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

    // A simple UserDatabase class
    private class UserDatabase {
        private List<User> users;

        public java_38805_CredentialValidator_A03() {
            users = new ArrayList<>();
            users.add(new User("admin", "password"));
            users.add(new User("user", "password"));
        }

        public User getUser(String username) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null;
        }
    }
}