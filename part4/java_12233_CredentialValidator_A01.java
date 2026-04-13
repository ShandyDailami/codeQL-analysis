public class java_12233_CredentialValidator_A01 {
    private String correctUsername;
    private String correctPassword;

    // Constructor
    public java_12233_CredentialValidator_A01(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        if (username != null && username.equals(correctUsername) &&
            password != null && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}