import java.util.HashMap;
import java.util.Map;

public class java_16859_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16859_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session " + sessionId + " started for user " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + userName);
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " does not exist");
            return;
        }

        String userName = sessionMap.get(sessionId);
        System.out.println("Session " + sessionId + " exists for user " + userName);
    }
}