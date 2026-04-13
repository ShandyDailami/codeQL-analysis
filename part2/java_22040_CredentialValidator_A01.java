public class java_22040_CredentialValidator_A01 implements CredentialValidator {

    // Define a hardcoded password
    private final String hardcodedPassword = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        // Get the provided username
        String username = credentials.getUsername();

        // If the hardcoded password matches the provided username, return true
        if (hardcodedPassword.equals(username)) {
            return true;
        } else {
            // Otherwise, return false
            return false;
        }
    }
}