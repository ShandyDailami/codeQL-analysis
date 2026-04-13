public class java_34080_CredentialValidator_A08 implements CredentialValidator {
    // Fields to hold the real data
    private String validUsername;
    private String validPassword;

    // Constructor
    public java_34080_CredentialValidator_A08(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    // CredentialValidator method
    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        // Compare the submitted username and password with the valid ones
        if (credential.getIdentifier().equals(validUsername) &&
            credential.getPassword().equals(validPassword)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}