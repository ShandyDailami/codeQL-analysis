public class java_26228_CredentialValidator_A08 {

    private final String validUsername;
    private final String validPassword;

    public java_26228_CredentialValidator_A08(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    public boolean validate(String username, String password) {
        if (username.equals(this.validUsername) && password.equals(this.validPassword)) {
            return true;
        } else {
            return false;
        }
    }
}