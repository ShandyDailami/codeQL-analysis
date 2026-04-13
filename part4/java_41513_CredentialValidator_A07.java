public class java_41513_CredentialValidator_A07 {

    private final String expectedUsername;
    private final String expectedPassword;

    public java_41513_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isCredentialsValid(String username, String password) {
        return this.expectedUsername.equals(username) && this.expectedPassword.equals(password);
    }
}