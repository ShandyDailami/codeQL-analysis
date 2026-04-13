public class java_24363_CredentialValidator_A01 {

    private String correctUsername;
    private String correctPassword;

    public java_24363_CredentialValidator_A01(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validateCredentials(String username, String password) {
        if (username != null && username.equals(correctUsername) && password != null && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}