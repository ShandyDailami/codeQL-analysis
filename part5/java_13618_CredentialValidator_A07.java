// Start of code snippet
public class java_13618_CredentialValidator_A07 implements CredentialValidator {

    private static final String USERNAME = "myusername";
    private static final String PASSWORD = "mypassword";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationFailedException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}
// End of code snippet