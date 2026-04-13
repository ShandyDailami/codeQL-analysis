public class java_22500_CredentialValidator_A03 implements javax.security.auth.CredentialValidator<UsernamePasswordCredentials> {

    // Username and password for validation
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) {
        // Check if username and password match
        if (credentials.getUsername().equals(USERNAME) &&
                credentials.getPassword().equals(PASSWORD)) {
            return credentials;
        } else {
            // If credentials do not match, throw a SecurityException
            throw new SecurityException("Invalid username or password");
        }
    }
}