public class java_13136_CredentialValidator_A07 {

    // Step 1: Create a Credential object with userID and password
    private Credential credential;

    // Step 2: Initialize the credential object
    public java_13136_CredentialValidator_A07() {
        this.credential = new Credential("username", "password");
    }

    // Step 3: Implement the validate method
    public boolean validate(String username, String password) {
        return this.credential.validate(username, password);
    }

    // Step 4: Inner Credential class
    public class Credential {
        private String userID;
        private String password;

        public java_13136_CredentialValidator_A07(String userID, String password) {
            this.userID = userID;
            this.password = password;
        }

        public boolean validate(String username, String password) {
            return this.userID.equals(username) && this.password.equals(password);
        }
    }
}