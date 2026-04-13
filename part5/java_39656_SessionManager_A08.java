import java.util.HashMap;
import java.util.Map;

public class java_39656_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_39656_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
            return;
        }
        sessionMap.put(sessionId, userId);
        System.out.println("Started session: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for: " + sessionId);
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Ended session: " + sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists for: " + sessionId);
            return null;
        }
        return sessionMap.get(sessionId);
    }
}