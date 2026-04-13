import java.util.Arrays;
import java.util.List;

public class java_31166_CredentialValidator_A03 {
    // Hard-coded list of valid credentials
    private static final List<Credential> VALID_CREDENTIALS = Arrays.asList(
            new Credential("admin", "password123"),
            new Credential("user1", "password123"),
            new Credential("user2", "password123"));

    // Inner class to represent a credential
    public static class Credential {
        private String username;
        private String password;

        public java_31166_CredentialValidator_A03(String username, String password) {
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

    // Main method
    public static void main(String[] args) {
        authenticate("admin", "password123");
        authenticate("user1", "password123");
        authenticate("invalid", "invalid");
    }

    // Method to authenticate a user
    public static void authenticate(String username, String password) {
        for (Credential credential : VALID_CREDENTIALS) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                System.out.println("Authentication successful for user: " + username);
                return;
            }
        }
        System.out.println("Authentication failed for user: " + username);
    }
}