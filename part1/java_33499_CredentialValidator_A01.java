public class java_33499_CredentialValidator_A01 implements CredentialValidator {

    // Hardcoded username and password
    private final String hardcodedUsername = "admin";
    private final String hardcodedPassword = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws BadCredentialsException {
        // Check if the provided username and password match the hardcoded values
        if (credentials.getUsername().equals(hardcodedUsername) &&
                credentials.getPassword().equals(hardcodedPassword)) {
            return true;
        } else {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}