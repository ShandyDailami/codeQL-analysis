import java.util.HashMap;
import java.util.Map;

public class java_08615_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08615_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " already exists!");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session " + sessionId + " for user " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session " + sessionId + " for user " + userId);
        } else {
            System.out.println("Error: Session " + sessionId + " does not exists!");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Error: Session " + sessionId + " does not exists!");
            return null;
        }
    }
}