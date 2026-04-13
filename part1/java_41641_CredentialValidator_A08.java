public class java_41641_CredentialValidator_A08 implements CredentialValidator {
    private final String expectedUsername;
    private final String expectedPassword;

    public java_41641_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(String username, String password) throws CredentialException {
        if (!expectedUsername.equals(username)) {
            throw new CredentialException("Invalid username");
        }
        if (!expectedPassword.equals(password)) {
            throw new CredentialException("Invalid password");
        }
        return true;
    }
}