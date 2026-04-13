public class java_15172_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws CredentialException {
        String providedUsername = credentials.getUsername();
        String providedPassword = credentials.getPassword();

        if (providedUsername == null || providedPassword == null) {
            throw new CredentialException("Username and password cannot be null.");
        }

        if (providedUsername.equals(USERNAME) && providedPassword.equals(PASSWORD)) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password.");
        }
    }
}