import java.security.InvalidParameterException;

public class java_15389_CredentialValidator_A08 {

    public boolean isValid(String username, String password) {
        // Assume we have a method to authenticate the user
        // This method should return true if the user is valid, false otherwise
        // If the user is not valid, it should throw an InvalidParameterException
        if (isUserValid(username, password)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }

    private boolean isUserValid(String username, String password) {
        // Simulate user authentication
        // This method should return true if the username and password match, false otherwise
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

}