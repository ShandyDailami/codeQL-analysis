import java.util.HashMap;
import java.util.Map;

public class java_19940_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_19940_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
            return;
        }

        sessionMap.put(sessionId, userId);
        System.out.println("Started session with id: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists with id: " + sessionId);
            return;
        }

        sessionMap.remove(sessionId);
        System.out.println("Ended session with id: " + sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No session exists with id: " + sessionId);
            return null;
        }

        return sessionMap.get(sessionId);
    }
}