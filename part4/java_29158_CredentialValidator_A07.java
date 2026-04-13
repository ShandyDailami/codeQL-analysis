import java.util.ArrayList;
import java.util.List;

public class java_29158_CredentialValidator_A07 {
    private List<Credential> validCredentials;

    public java_29158_CredentialValidator_A07() {
        // Initialize valid credentials.
        validCredentials = new ArrayList<>();
        validCredentials.add(new Credential("user1", "password1"));
        validCredentials.add(new Credential("user2", "password2"));
        validCredentials.add(new Credential("user3", "password3"));
    }

    public boolean validate(String username, String password) {
        // Iterate through the list of valid credentials.
        for (Credential credential : validCredentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private class Credential {
        private String username;
        private String password;

        public java_29158_CredentialValidator_A07(String username, String password) {
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