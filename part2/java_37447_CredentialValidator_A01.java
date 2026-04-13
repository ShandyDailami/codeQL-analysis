public class java_37447_CredentialValidator_A01 {

    // A list of hardcoded credentials
    private static final List<Credential> credentials = Arrays.asList(
        new Credential("user1", "password1"),
        new Credential("user2", "password2"),
        new Credential("user3", "password3")
    );

    // The CredentialValidator will call this method to validate the credentials
    public boolean validate(String username, String password) {
        // Iterate through the list of credentials
        for (Credential credential : credentials) {
            // If the username and password match a credential in the list...
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                // ... return true, indicating successful validation
                return true;
            }
        }

        // If we've made it here, no match was found. Return false, indicating failed validation
        return false;
    }

    // A simple Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_37447_CredentialValidator_A01(String username, String password) {
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