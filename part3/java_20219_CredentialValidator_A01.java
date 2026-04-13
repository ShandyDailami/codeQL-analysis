// import necessary libraries
import java.util.Arrays;

public class java_20219_CredentialValidator_A01 {
    // This is a simple example of a CredentialValidator

    // A predefined list of users and their hashed versions of their passwords
    private static final User[] USERS = {
        new User("user1", "password1"),
        new User("user2", "password2"),
        new User("user3", "password3"),
    };

    public boolean validate(String username, String password) {
        // Attempt to find the user in our list
        User user = Arrays.stream(USERS)
            .filter(u -> u.getUsername().equals(username))
            .findFirst()
            .orElse(null);

        // If we found a user, check the password
        if (user != null && user.getPassword().equals(hashPassword(password))) {
            return true;
        } else {
            return false;
        }
    }

    // A simple hashing function for demonstration purposes
    private String hashPassword(String password) {
        // In a real application, you would use a more secure method of hashing and salt here
        return password; // for demonstration purposes only
    }

    // User class for demonstration purposes
    private static class User {
        private String username;
        private String password;

        public java_20219_CredentialValidator_A01(String username, String password) {
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