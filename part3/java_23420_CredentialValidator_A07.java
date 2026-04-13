public class java_23420_CredentialValidator_A07 {

    // Hardcoded list of users and passwords.
    private static final User[] users = {
        new User("user1", "password1"),
        new User("user2", "password2"),
        new User("user3", "password3")
    };

    // Inner class to hold user information.
    private static class User {
        private String username;
        private String password;

        public java_23420_CredentialValidator_A07(String username, String password) {
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

    // Validate a username and password.
    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Main method for testing.
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1"));  // true
        System.out.println(validator.validate("user4", "password4"));  // false
    }
}