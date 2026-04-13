import java.util.Arrays;
import java.util.List;

public class java_14916_CredentialValidator_A03 {

    // Hardcoded list of credentials
    private static final List<Credential> credentials = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3")
    );

    public boolean validate(String username, String password) {
        // Iterate over the list of credentials
        for (Credential credential : credentials) {
            // If the username and password match, return true
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        // If no match found, return false
        return false;
    }

    // Inner class for Credential
    public static class Credential {
        private String username;
        private String password;

        public java_14916_CredentialValidator_A03(String username, String password) {
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