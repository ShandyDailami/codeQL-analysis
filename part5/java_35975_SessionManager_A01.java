import java.util.HashMap;
import java.util.Map;

public class java_35975_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_35975_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // In a real-world application, passwords should never be stored in plain text.
        // This is a security sensitive operation related to A01_BrokenAccessControl.
        // For the purpose of this example, we'll store passwords in plain text.
        if (validatePassword(password)) {
            sessionMap.put(username, password);
        } else {
            throw new SecurityException("Invalid password!");
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public String getPassword(String username) {
        return sessionMap.get(username);
    }

    private boolean validatePassword(String password) {
        // Simulate password validation. In a real-world application,
        // you'd want to use a more secure way of validating passwords.
        return password != null && !password.isEmpty();
    }
}