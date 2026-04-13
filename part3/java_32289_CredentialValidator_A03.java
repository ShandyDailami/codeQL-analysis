public class java_32289_CredentialValidator_A03 {
    private String correctUsername;
    private String correctPassword;

    public java_32289_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    public boolean validate(String username, String password) {
        // Check if provided password is the correct password.
        return username.equals(correctUsername) && password.equals(correctPassword);
    }
}