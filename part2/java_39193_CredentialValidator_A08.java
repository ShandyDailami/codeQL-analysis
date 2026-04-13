import java.security.InvalidParameterException;

public class java_39193_CredentialValidator_A08 {

    // This method is used to create a user object in the legacy system.
    // In the actual system, this would involve making a call to a database or another external service.
    public User createUser(String username, String password) {
        // Normally, we'd hash the password before storing it. However, for this example, we'll just store it as it is.
        return new User(username, password);
    }

    // This method is used to authenticate a user object in the legacy system.
    // In the actual system, this would involve comparing a hashed password stored in the database.
    public boolean authenticateUser(User user, String password) {
        // Normally, we'd hash the password and compare the hashed password stored in the database.
        // However, for this example, we'll just compare the stored password and the provided password.
        return user.getPassword().equals(password);
    }

    // CredentialValidator interface
    public interface CredentialValidator {
        User createUser(String username, String password);
        boolean authenticateUser(User user, String password);
    }

    // User class
    public static class User {
        private String username;
        private String password;

        public java_39193_CredentialValidator_A08(String username, String password) {
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