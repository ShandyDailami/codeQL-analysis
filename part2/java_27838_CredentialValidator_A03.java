import java.security.InvalidParameterException;

public class java_27838_CredentialValidator_A03 {

    public boolean isValidCredentials(String username, String password) {
        // In a real-world application, you would likely need to store these credentials securely,
        // and you'd want to use a more secure method to validate them.
        // This is a simple example, where we're using a hardcoded username and password.

        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }
}