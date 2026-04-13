public class java_21974_CredentialValidator_A07 implements CredentialValidator {

    // Hardcoded username and password
    private String username = "admin";
    private String password = "password";

    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        // Get the username and password from the credential
        String providedUsername = c.getUsername();
        String providedPassword = c.getPassword();

        // Check if the provided username and password match the hardcoded ones
        if (username.equals(providedUsername) && password.equals(providedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}