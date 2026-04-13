import java.util.Objects;

public class java_40996_CredentialValidator_A07 {
    // Define the user credentials
    private UserCredential user;

    // Constructor
    public java_40996_CredentialValidator_A07() {
        this.user = new UserCredential("user", "password");
    }

    // Method to validate the user credentials
    public boolean validate(UserCredential credential) {
        // Check if the provided credential is not null
        if (credential == null) {
            throw new IllegalArgumentException("Credential cannot be null");
        }

        // Compare the provided credential with the user credentials
        if (Objects.equals(credential.getUsername(), user.getUsername()) &&
            Objects.equals(credential.getPassword(), user.getPassword())) {
            return true;
        }

        return false;
    }

    // Class for the user credentials
    public static class UserCredential {
        private String username;
        private String password;

        public java_40996_CredentialValidator_A07(String username, String password) {
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