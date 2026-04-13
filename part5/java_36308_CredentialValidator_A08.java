import java.security.InvalidParameterException;
import java.util.Base64;

public class java_36308_CredentialValidator_A08 {

    // This method checks if the provided password matches the user's password.
    // It converts the password and user's password to Base64 strings and then checks if they are equal.
    // If they are not equal, it throws an InvalidParameterException.
    public void validatePassword(String userPassword, String password) {
        if (!Base64.getEncoder().encodeToString(userPassword.getBytes()).equals(password)) {
            throw new InvalidParameterException("Invalid password");
        }
    }

    // This method checks if the provided username matches the user's username.
    // It converts the username and user's username to Base64 strings and then checks if they are equal.
    // If they are not equal, it throws an InvalidParameterException.
    public void validateUsername(String userUsername, String username) {
        if (!Base64.getEncoder().encodeToString(userUsername.getBytes()).equals(username)) {
            throw new InvalidParameterException("Invalid username");
        }
    }
}