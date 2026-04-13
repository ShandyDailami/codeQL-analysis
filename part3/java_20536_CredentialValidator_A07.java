public class java_20536_CredentialValidator_A07 implements CredentialValidator {

    // Hard-coded credentials
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        // Get the credentials from the Credential object
        String username = c.getUsername();
        String password = c.getPassword();

        // Validate the credentials
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}