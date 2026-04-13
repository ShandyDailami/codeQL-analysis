public class java_20338_CredentialValidator_A03 {
    private String correctUsername;
    private String correctPassword;

    public java_20338_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        if (username != null && username.equals(correctUsername) &&
            password != null && password.equals(correctPassword)) {
            return true;
        }

        return false;
    }
}