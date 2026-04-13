import java.util.HashMap;
import java.util.Map;

public class java_20778_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_20778_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void authFailure(String sessionId) {
        if (isSessionActive(sessionId)) {
            endSession(sessionId);
            System.out.println("AuthFailure: " + getUserFromSession(sessionId) + " has been logged out due to failed authentication.");
        } else {
            System.out.println("AuthFailure: Session " + sessionId + " is not active.");
        }
    }
}