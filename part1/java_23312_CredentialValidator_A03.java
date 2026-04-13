public class java_23312_CredentialValidator_A03 {
    // This is a placeholder for the real database connection
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("admin", "password123"));
        userList.add(new User("user1", "password123"));
        userList.add(new User("user2", "password123"));
    }

    public boolean validateCredentials(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class for simplifying the example
    static class User {
        private String username;
        private String password;

        public java_23312_CredentialValidator_A03(String username, String password) {
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

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("admin", "password123"));  // prints true
        System.out.println(validator.validateCredentials("invalid", "password123"));  // prints false
    }
}