import java.util.Base64;

public class java_16684_CredentialValidator_A03 {

    // This method validates the given plain text password and returns a boolean indicating whether the password is valid.
    public boolean validatePassword(String password) {
        // A very basic check for a valid password. In a real application, you would likely use a more complex algorithm.
        if (password != null && !password.isEmpty() && password.length() >= 8) {
            return true;
        }
        return false;
    }

    // This method validates the given plain text password and returns a boolean indicating whether the password is valid.
    // It also validates the password against a stored hash of the entered password.
    public boolean validatePassword(String password, String hash) {
        // First, we decode the stored hash to get the expected password.
        String expectedPassword = new String(Base64.getDecoder().decode(hash));
        
        // Then, we compare the entered password to the expected password.
        if (password != null && !password.isEmpty() && password.equals(expectedPassword)) {
            return true;
        }
        return false;
    }
}