public class java_03567_CredentialValidator_A01 implements CredentialValidator {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        // check if the provided username and password match the predefined values
        if (credentials.getUsername().equals(VALID_USERNAME) && credentials.getPassword().equals(VALID_PASSWORD)) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid username or password");
        }
    }
}