public class java_10989_CredentialValidator_A07 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_10989_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Credential c) throws CredentialValidationException {
        String username = c.getIdentifier();
        String password = c.getCredential();

        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            return true;
        } else {
            throw new CredentialValidationException("Authentication failed.");
        }
    }

}