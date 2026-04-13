public class java_21200_CredentialValidator_A07 implements CredentialValidator {

    private String expectedUsername;
    private String expectedPassword;

    public java_21200_CredentialValidator_A07(String username, String password) {
        this.expectedUsername = username;
        this.expectedPassword = password;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        if (credential.getIdentifier().equals(expectedUsername) &&
            credential.getSecret().equals(expectedPassword)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}