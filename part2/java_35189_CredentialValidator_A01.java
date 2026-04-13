import java.util.Base64;
import java.util.UUID;

public class java_35189_CredentialValidator_A01 {

    public static class BrokenAccessControlException extends Exception {
        public java_35189_CredentialValidator_A01(String message) {
            super(message);
        }
    }

    public static class User {
        private String username;
        private String password;

        public java_35189_CredentialValidator_A01(String username, String password) {
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

    private static final String SALT = UUID.randomUUID().toString();

    public static String hashPassword(String password) {
        return Base64.getEncoder().encodeToString((SALT + password).getBytes());
    }

    public static void validate(User user, String passwordAttempt) throws BrokenAccessControlException {
        if (!user.getPassword().equals(hashPassword(passwordAttempt))) {
            throw new BrokenAccessControlException("Invalid password");
        }
    }

    public static void main(String[] args) {
        try {
            User user = new User("admin", hashPassword("password"));
            validate(user, "wrongpassword");
        } catch (BrokenAccessControlException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }
}