public class java_13823_CredentialValidator_A01 {
    // Model for a user
    public static class User {
        private String username;
        private String password;

        public java_13823_CredentialValidator_A01(String username, String password) {
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

    // CredentialValidator interface
    public interface CredentialValidator {
        User validate(String username, String password);
    }

    // In-memory CredentialValidator
    public static class InMemoryCredentialValidator implements CredentialValidator {
        private User[] users = {
                new User("user1", "password1"),
                new User("user2", "password2"),
                new User("user3", "password3"),
        };

        @Override
        public User validate(String username, String password) {
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // Initialize validator
        CredentialValidator validator = new InMemoryCredentialValidator();

        // Validate user
        User user = validator.validate("user1", "password1");

        // Check if user is valid
        if (user != null) {
            System.out.println("User is valid: " + user.getUsername());
        } else {
            System.out.println("Invalid credentials");
        }
    }
}