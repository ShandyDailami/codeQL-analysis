import java.util.Base64;

public class java_17724_CredentialValidator_A03 {
    private String correctUsername;
    private String correctPassword;

    public java_17724_CredentialValidator_A03(String username, String password) {
        this.correctUsername = username;
        this.correctPassword = password;
    }

    public boolean isCredentialsValid(String enteredUsername, String enteredPassword) {
        boolean isValidUsername = enteredUsername.equals(this.correctUsername);
        boolean isValidPassword = this.correctPassword.equals(enteredPassword);
        return isValidUsername && isValidPassword;
    }

    public static void main(String[] args) {
        // Create a CredentialValidator instance with a correct username and password
        CredentialValidator validator = new CredentialValidator("admin", "password");

        // Test with a valid username and password
        System.out.println(validator.isCredentialsValid("admin", "password"));  // Outputs: true

        // Test with an invalid username and password
        System.out.println(validator.isCredentialsValid("wrong_username", "wrong_password"));  // Outputs: false
    }
}