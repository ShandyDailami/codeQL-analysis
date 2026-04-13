public class java_06421_CredentialValidator_A01 implements CredentialValidator {

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "password";

    private String username;
    private String password;

    public java_06421_CredentialValidator_A01() {
        this.username = DEFAULT_USERNAME;
        this.password = DEFAULT_PASSWORD;
    }

    public java_06421_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        if(credential == null) {
            throw new InvalidCredentialException("Credential cannot be null.");
        }

        String enteredUsername = credential.getIdentifier();
        String enteredPassword = credential.getPassword();

        // If username and password are not provided, use default values
        if(enteredUsername == null || enteredPassword == null) {
            enteredUsername = DEFAULT_USERNAME;
            enteredPassword = DEFAULT_PASSWORD;
        }

        // Check if entered credentials match expected credentials
        if(enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid credentials.");
        }
    }
}