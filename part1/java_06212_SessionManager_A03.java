import java.util.HashMap;
import java.util.Map;

public class java_06212_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_06212_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with id " + sessionId + " and user id " + userId);
        } else {
            System.out.println("Session with id " + sessionId + " already exists");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id " + sessionId + " and user id " + userId);
        } else {
            System.out.println("No session with id " + sessionId + " exists");
        }
    }
}