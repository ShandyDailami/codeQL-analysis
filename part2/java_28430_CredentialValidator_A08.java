public class java_28430_CredentialValidator_A08 {

    // Define a class that represents a user
    public class User {
        private String username;
        private String password;

        public java_28430_CredentialValidator_A08(String username, String password) {
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

    // Define a class that validates the user credentials
    public class CredentialValidator {
        private User[] users;

        public java_28430_CredentialValidator_A08() {
            users = new User[10];
            users[0] = new User("Alice", "password123");
            users[1] = new User("Bob", "password321");
            // Add more users here if needed
        }

        public boolean validate(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test valid credentials
        if (validator.validate("Alice", "password123")) {
            System.out.println("Validated Alice");
        } else {
            System.out.println("Failed to validate Alice");
        }

        // Test invalid credentials
        if (!validator.validate("Charlie", "wrongpassword")) {
            System.out.println("Validated Charlie");
        } else {
            System.out.println("Failed to validate Charlie");
        }
    }
}