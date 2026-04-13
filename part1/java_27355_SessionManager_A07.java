import java.util.HashMap;
import java.util.Map;

public class java_27355_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27355_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (validatePassword(password)) {
            sessionMap.put(username, password);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Failed to start session for user: " + username);
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
        System.out.println("Session ended for user: " + username);
    }

    private boolean validatePassword(String password) {
        // This is a simple password validation. In a real-world application, you should use a secure way of validating passwords.
        // For this example, we're just checking if the password is not empty.
        return !password.isEmpty();
    }
}