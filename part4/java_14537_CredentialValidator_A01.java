public class java_14537_CredentialValidator_A01 {

    // Credential object
    private Credential credential;

    public java_14537_CredentialValidator_A01(Credential credential) {
        this.credential = credential;
    }

    // Method to check if the credentials are valid
    public boolean validate() {
        // Hard-coded username and password
        String hardCodedUsername = "admin";
        String hardCodedPassword = "password";

        // Check if the credentials are valid
        if (credential.getUsername().equals(hardCodedUsername)
                && credential.getPassword().equals(hardCodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Credential class
    public static class Credential {
        private String username;
        private String password;

        public java_14537_CredentialValidator_A01(String username, String password) {
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