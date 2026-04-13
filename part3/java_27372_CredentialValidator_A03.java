public class java_27372_CredentialValidator_A03 {

    // Simplified version of a Credential object for testing
    private class Credential {
        private String username;
        private String password;

        public java_27372_CredentialValidator_A03(String username, String password) {
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

    private java_27372_CredentialValidator_A03() {}

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // In a real-world application, you would want to use a secure method of hashing and comparing passwords
        // for simplicity, we'll just check if the username is 'admin' and the password is 'password'
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }

        return false;
    }

    // Testing the CredentialValidator
    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");
        System.out.println("Credentials are valid: " + CredentialValidator.validate(credential.getUsername(), credential.getPassword()));

        Credential invalidCredential = new Credential("invalid", "invalid");
        System.out.println("Credentials are valid: " + CredentialValidator.validate(invalidCredential.getUsername(), invalidCredential.getPassword()));
    }
}