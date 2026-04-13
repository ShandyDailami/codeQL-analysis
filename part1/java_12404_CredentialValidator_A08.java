public class java_12404_CredentialValidator_A08 {
    private String correctUsername;
    private String correctPassword;

    public java_12404_CredentialValidator_A08(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}