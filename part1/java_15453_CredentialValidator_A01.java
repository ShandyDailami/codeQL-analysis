public class java_15453_CredentialValidator_A01 {

    // In-memory user database
    private static List<User> userDatabase = new ArrayList<>();

    // Static block for populating user database
    static {
        userDatabase.add(new User("user1", "pass1", "ROLE_USER"));
        userDatabase.add(new User("user2", "pass2", "ROLE_ADMIN"));
    }

    // Credential validator
    public boolean validate(String username, String password) {
        for (User user : userDatabase) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    // User class
    public static class User {
        private String username;
        private String password;
        private String role;

        public java_15453_CredentialValidator_A01(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}