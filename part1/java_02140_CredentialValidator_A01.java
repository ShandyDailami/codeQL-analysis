public class java_02140_CredentialValidator_A01 implements CredentialValidator {

    // Username and password to validate against
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        // Check if the credentials match
        if (credentials.getUsername().equals(USERNAME) && credentials.getPassword().equals(PASSWORD)) {
            return true;
        } else {
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}