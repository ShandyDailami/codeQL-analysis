import java.util.HashMap;
import java.util.Map;

public class java_29243_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_29243_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isPasswordValid(password)) {
            sessionMap.put(username, password);
        } else {
            throw new AuthFailureException("Invalid password for user " + username);
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public String getSessionPassword(String username) {
        return sessionMap.get(username);
    }

    private boolean isPasswordValid(String password) {
        // Implement your password validation logic here
        // Return true if the password is valid, false otherwise
        return true;
    }
}