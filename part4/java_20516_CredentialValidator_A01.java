public class java_20516_CredentialValidator_A01 {

    private String correctUsername;
    private String correctPassword;

    public java_20516_CredentialValidator_A01(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean isValid(String username, String password) {
        if (correctUsername.equals(username) && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}