import java.util.HashMap;
import java.util.Map;

public class java_12719_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12719_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
        System.out.println("Session " + sessionId + " started.");
    }

    public void endSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
            System.out.println("Session " + sessionId + " ended.");
        } else {
            System.out.println("No active session with id " + sessionId + " found.");
        }
    }

    public String getSessionStatus(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No active session with id " + sessionId + " found.";
        }
    }
}