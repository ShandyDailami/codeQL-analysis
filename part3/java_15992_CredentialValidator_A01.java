public class java_15992_CredentialValidator_A01 {

    private String correctUsername;
    private String correctPassword;

    public java_15992_CredentialValidator_A01() {
        // initialize with correct credentials for testing
        this.correctUsername = "admin";
        this.correctPassword = "password";
    }

    public boolean validate(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}