public class java_05974_CredentialValidator_A08 {
    private String correctUsername;
    private String correctPassword;

    public java_05974_CredentialValidator_A08(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean isValidCredentials(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}