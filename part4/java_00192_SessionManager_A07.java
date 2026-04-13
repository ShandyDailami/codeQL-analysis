import java.util.HashMap;
import java.util.Map;

public class java_00192_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00192_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isPasswordSecure(password)) {
            sessionMap.put(username, password);
        } else {
            // If password is not secure, throw an exception
            throw new SecurityFailureException("Attempted to store password in session.");
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    private boolean isPasswordSecure(String password) {
        // Implementation of password security rules here
        // This is a placeholder and should be replaced with actual logic
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }
}