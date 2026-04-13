public class java_03347_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        if (credentials.getUsername() == null || credentials.getUsername().trim().isEmpty()) {
            throw new InvalidCredentialsException("Username cannot be null or empty");
        }

        if (credentials.getPassword() == null || credentials.getPassword().trim().isEmpty()) {
            throw new InvalidCredentialsException("Password cannot be null or empty");
        }

        // Simulate a security check
        // This is a very simplified version of a secure password validation
        if ("badpassword".equals(credentials.getPassword())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        // If all checks are passed, return true
        return true;
    }
}