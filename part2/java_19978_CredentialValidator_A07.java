import java.util.Arrays;
import java.util.List;

public class java_19978_CredentialValidator_A07 {

    private List<Credential> credentials;

    // Initialize credentials
    public java_19978_CredentialValidator_A07() {
        this.credentials = Arrays.asList(
                new Credential("user1", "password1"),
                new Credential("user2", "password2"),
                new Credential("user3", "password3")
        );
    }

    // Method to validate a credential
    public boolean validateCredential(String username, String password) {
        for (Credential credential : credentials) {
            if (credential.getUsername().equals(username) &&
                    credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Credential class
    public class Credential {
        private String username;
        private String password;

        public java_19978_CredentialValidator_A07(String username, String password) {
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