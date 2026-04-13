public class java_23605_CredentialValidator_A08 implements CredentialValidator {

    // Define the default password for simplicity. In a real application,
    // you should use a stronger password hashing mechanism.
    private static final String DEFAULT_PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        // Get the username and password
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        // Check if the username and password match our defaults
        if (username.equals("user") && password.equals(DEFAULT_PASSWORD)) {
            return true;
        }

        // If the username and password do not match, return false
        return false;
    }
}