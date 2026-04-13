public class java_02281_CredentialValidator_A01 implements CredentialValidator {

    // Store the expected password for verification
    private String expectedPassword;

    public java_02281_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        // Get the provided username and password
        String providedUsername = credentials.getUsername();
        String providedPassword = credentials.getPassword();

        // Check if the provided password matches the expected password
        if (providedPassword.equals(expectedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialsException("Invalid password");
        }
    }
}