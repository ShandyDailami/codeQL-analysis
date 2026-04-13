import java.util.Base64;
import java.util.Optional;

public class java_10364_CredentialValidator_A01 {

    // Example of a broken access control case
    public Optional<User> validateUserCredentials(String userId, String password) {
        // This is a simplified example, the real world case is more complicated
        // We should not store passwords in plain text, use a hashing algorithm instead
        String expectedPassword = "expectedPassword";

        // In real world, the following line of code is broken
        // It should be replaced with a real hashing algorithm
        if (!password.equals(expectedPassword)) {
            return Optional.empty();
        }

        // If we reach here, the password is correct
        return Optional.of(new User(userId, password));
    }

    // Example of a User class
    public static class User {
        private String userId;
        private String password;

        public java_10364_CredentialValidator_A01(String userId, String password) {
            this.userId = userId;
            this.password = password;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }
}