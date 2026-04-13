import java.util.HashSet;
import java.util.Set;

public class java_37352_CredentialValidator_A03 {
    private Set<String> validUsers;

    public java_37352_CredentialValidator_A03() {
        validUsers = new HashSet<>();
        // Add some valid users here
        validUsers.add("user");
        validUsers.add("admin");
    }

    public boolean isValidUsername(String username) {
        return validUsers.contains(username);
    }

    public boolean isStrongPassword(String password) {
        // Custom password strength checker: at least one uppercase, one lowercase, one digit and one special character
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$");
    }

    public Credential validate(String username, String password) {
        if (!isValidUsername(username)) {
            return new Credential(false, "Invalid username");
        }

        if (!isStrongPassword(password)) {
            return new Credential(false, "Password is too weak");
        }

        return new Credential(true, "Successfully logged in");
    }

    public static class Credential {
        private boolean success;
        private String message;

        public java_37352_CredentialValidator_A03(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}