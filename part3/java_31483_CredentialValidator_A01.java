public class java_31483_CredentialValidator_A01 implements CredentialValidator {

    // Private field to store the username
    private String username;

    // Private field to store the password
    private String password;

    // Constructor to initialize the username and password fields
    public java_31483_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check if the provided username and password match those stored in the object
    @Override
    public boolean validate(String enteredUsername, String enteredPassword) throws CredentialException {
        // If the entered username and password match those stored, return true
        if (enteredUsername.equals(this.username) && enteredPassword.equals(this.password)) {
            return true;
        } else {
            // Otherwise, throw a CredentialException
            throw new CredentialException("Invalid username or password");
        }
    }

    // No additional methods needed in this example

}