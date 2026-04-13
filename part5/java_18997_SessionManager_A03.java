import java.util.HashMap;
import java.util.Map;

public class java_18997_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_18997_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Start a new session for the user
        sessionMap.put(userId, "Active");
    }

    public void endSession(String userId) {
        // End a session for the user
        sessionMap.put(userId, "Inactive");
    }

    public String getSessionState(String userId) {
        // Get the state of the session for the user
        return sessionMap.get(userId);
    }

    public boolean isSessionActive(String userId) {
        // Check if the session is active for the user
        String sessionState = sessionMap.get(userId);
        return sessionState != null && sessionState.equals("Active");
    }

    public boolean isUserAuthorized(String userId, String password) {
        // Check if the user is authorized
        // This is a dummy check, replace it with your real authentication logic
        return userId != null && password != null && !userId.isEmpty() && !password.isEmpty();
    }
}