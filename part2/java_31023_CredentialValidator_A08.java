public class java_31023_CredentialValidator_A08 {

    // Define hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate the user's credentials
    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Method to check if the user's credentials are valid
    public boolean isValid(Credential credential) {
        return validate(credential.getUsername(), credential.getPassword());
    }

    // Credential class
    public class Credential {
        private String username;
        private String password;

        public java_31023_CredentialValidator_A08(String username, String password) {
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