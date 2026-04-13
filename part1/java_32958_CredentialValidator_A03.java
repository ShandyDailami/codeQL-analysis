public class java_32958_CredentialValidator_A03 implements CredentialValidator {

    // A hard-coded pattern for validation
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        // Validate the password
        if (!credentials.getPassword().matches(PASSWORD_PATTERN)) {
            throw new InvalidCredentialsException("Invalid password");
        }
        
        // Password is valid
        return true;
    }
}