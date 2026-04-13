public class java_21331_CredentialValidator_A08 {
    // Define a Credential object.
    private Credential credential;

    // Constructor for the Credential object.
    public java_21331_CredentialValidator_A08(String username, String password) {
        this.credential = new Credential(username, password);
    }

    // Method to validate the credentials.
    public boolean validateCredentials() {
        // Create an array of usernames and passwords.
        String[] usernames = {"user1", "user2", "user3"};
        String[] passwords = {"password1", "password2", "password3"};

        // Check if the provided credentials match with the array.
        for (int i = 0; i < usernames.length; i++) {
            if (usernames[i].equals(credential.getUsername()) && passwords[i].equals(credential.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // Define a Credential class.
    public class Credential {
        private String username;
        private String password;

        public java_21331_CredentialValidator_A08(String username, String password) {
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