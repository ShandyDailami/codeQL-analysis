public class java_35180_CredentialValidator_A03 implements CredentialValidator {

    // Fields
    private String correctUsername;
    private String correctPassword;

    // Constructor
    public java_35180_CredentialValidator_A03(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    // Method to check if the provided username and password match the expected values
    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws InvalidCredentialsException {
        if (credentials.getUsername().equals(correctUsername) && credentials.getPassword().equals(correctPassword)) {
            return true;
        } else {
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}