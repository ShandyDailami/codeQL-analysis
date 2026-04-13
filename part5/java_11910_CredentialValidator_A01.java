import java.util.Arrays;
import java.util.List;

public class java_11910_CredentialValidator_A01 {
    // A list of valid credentials.
    private List<Credential> validCredentials = Arrays.asList(
        new Credential("user1", "password1"),
        new Credential("user2", "password2"),
        new Credential("user3", "password3")
    );

    // The CredentialValidator class does not use external frameworks.

    public boolean validate(String username, String password) {
        // Iterate over the valid credentials to find the matching one.
        for (Credential credential : validCredentials) {
            if (credential.matches(username, password)) {
                return true;
            }
        }

        // If no matching credential is found, return false.
        return false;
    }

    // Credential class is a simple data holder.
    private class Credential {
        private String username;
        private String password;

        public java_11910_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Method to check if the credential matches the given username and password.
        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}