public class java_31141_CredentialValidator_A01 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_31141_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Credential credential) throws AuthenticationFailedException {
        if (credential == null) {
            throw new AuthenticationFailedException("Null credentials");
        }

        if (credential.getUsername() == null || credential.getUsername().isEmpty()) {
            throw new AuthenticationFailedException("Missing username");
        }

        if (credential.getPassword() == null || credential.getPassword().isEmpty()) {
            throw new AuthenticationFailedException("Missing password");
        }

        if (!credential.getUsername().equals(expectedUsername)) {
            throw new AuthenticationFailedException("Invalid username");
        }

        if (!credential.getPassword().equals(expectedPassword)) {
            throw new AuthenticationFailedException("Invalid password");
        }

        return true;
    }
}