import java.util.HashMap;
import java.util.Map;

public class java_37824_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_37824_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id: " + sessionId);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}