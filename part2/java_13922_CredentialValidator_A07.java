public class java_13922_CredentialValidator_A07 implements CredentialValidator {
    private String expectedUsername;
    private String expectedPassword;

    public java_13922_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        if (expectedUsername.equals(username) && expectedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}