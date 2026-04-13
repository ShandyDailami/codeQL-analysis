public class java_19185_CredentialValidator_A01 {
    // Define a list of known credentials
    private static final List<Credential> knownCredentials = Arrays.asList(
            new Credential("user1", "password1"),
            new Credential("user2", "password2"),
            new Credential("user3", "password3")
    );

    // Credential class for storing username and password
    public static class Credential {
        private String username;
        private String password;

        public java_19185_CredentialValidator_A01(String username, String password) {
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

    // Method to validate credentials
    public static boolean validateCredentials(String username, String password) {
        // Loop through known credentials
        for (Credential credential : knownCredentials) {
            if (credential.getUsername().equals(username) && credential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}