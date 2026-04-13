import java.util.HashMap;
import java.util.Map;

public class java_22178_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_22178_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        // In a real-world application, you'd want to validate the sessionId and userId
        // and also check if the user has permission to start a session
        // This is left out for the sake of simplicity

        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // In a real-world application, you'd want to validate the sessionId
        // and also check if the sessionId is valid
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // In a real-world application, you'd want to validate the sessionId
        // and also check if the sessionId is valid

        sessionMap.remove(sessionId);
    }
}