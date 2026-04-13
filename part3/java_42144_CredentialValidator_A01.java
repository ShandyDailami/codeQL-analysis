public class java_42144_CredentialValidator_A01 implements CredentialValidator {

    // Hardcoded username and password
    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        // Extract the username and password from the credential
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Check if the extracted credentials match the hardcoded ones
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}