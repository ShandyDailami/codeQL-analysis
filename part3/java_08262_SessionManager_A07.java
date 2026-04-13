import java.util.HashMap;
import java.util.Map;

public class java_08262_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_08262_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("AuthFailure: Session already exists for user: " + userId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("AuthFailure: Session started for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("AuthFailure: Session ended for user: " + userId);
        } else {
            System.out.println("AuthFailure: No session exists for user: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("AuthFailure: No session exists for user: " + sessionId);
            return null;
        }
    }
}