public class java_02000_CredentialValidator_A03 implements CredentialValidator {

    private String correctUsername;
    private String correctPassword;

    // The constructor only requires the correct username and password for validation.
    public java_02000_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    // The validate method is used to validate the username and password.
    @Override
    public boolean validate(Credential c) throws InvalidCredentialException {
        // The correct username and password are compared to the provided username and password.
        // If they are the same, the Credential object is deemed valid.
        if (c.getUsername().equals(correctUsername) && c.getPassword().equals(correctPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password.");
        }
    }
}