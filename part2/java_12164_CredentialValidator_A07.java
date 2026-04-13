public class java_12164_CredentialValidator_A07 {

    // Define the valid users
    private static class User {
        private String username;
        private String password;

        public java_12164_CredentialValidator_A07(String username, String password) {
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

    private User[] validUsers;

    public java_12164_CredentialValidator_A07() {
        // Initialize the valid users
        validUsers = new User[] {
                new User("user1", "password1"),
                new User("user2", "password2"),
                new User("user3", "password3")
        };
    }

    public boolean validate(String username, String password) {
        for (User user : validUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        System.out.println(validator.validate("user1", "password1"));  // Should print true
        System.out.println(validator.validate("user4", "password4"));  // Should print false
    }
}