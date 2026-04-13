public class java_05143_CredentialValidator_A08 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_05143_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Credential c) throws CredentialValidationException {
        // Get the username and password from the credential
        String username = c.getIdentifier();
        String password = c.getCredential();

        // Check if the username and password match the expected values
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        } else {
            throw new CredentialValidationException("Invalid username or password");
        }
    }

    @Override
    public void initialize(String name, Map<String, String> properties) {
        // No-op for this example
    }

    @Override
    public void delete() {
        // No-op for this example
    }
}