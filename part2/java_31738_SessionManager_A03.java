import java.util.HashMap;
import java.util.Map;

public class java_31738_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_31738_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session with id " + sessionId + " already exists. Please use a new session id.");
            return;
        }
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with id " + sessionId + " exists.");
            return;
        }
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with id " + sessionId + " exists.");
            return null;
        }
        return sessionMap.get(sessionId);
    }
}