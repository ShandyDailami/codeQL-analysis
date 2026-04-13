import java.util.HashMap;
import java.util.Map;

public class java_37193_SessionManager_A07 {

    // In a real-world application, this would be a database or another form of persistent storage.
    private Map<String, String> userData = new HashMap<>();

    // User attempts to log in.
    public void login(String username, String password) {
        if (isValidUser(username, password)) {
            userData.put("username", username);
        } else {
            throw new AuthenticationFailureException("Invalid username or password");
        }
    }

    // User tries to access a resource.
    public void accessResource(String username) {
        if (!isValidSession(username)) {
            throw new AuthenticationFailureException("Invalid session");
        }
    }

    // Check if the user is valid.
    private boolean isValidUser(String username, String password) {
        // Logic to check the user against a database or another form of authentication.
        // In a real-world application, you'd want to use a secure method to handle user authentication.
        return true;
    }

    // Check if the session is valid.
    private boolean isValidSession(String username) {
        // Logic to check the session against a database or another form of authentication.
        // In a real-world application, you'd want to use a secure method to handle session authentication.
        return true;
    }

    // Exception for when an authentication failure occurs.
    private class AuthenticationFailureException extends RuntimeException {
        public java_37193_SessionManager_A07(String message) {
            super(message);
        }
    }
}