import java.util.HashMap;
import java.util.Map;

public class java_08929_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_08929_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authenticateUser(String sessionId, String password) {
        if (password.equals("securePassword")) {
            startSession(sessionId, "authenticatedUser");
        } else {
            endSession(sessionId);
        }
    }
}