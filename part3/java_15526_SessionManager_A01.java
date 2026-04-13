import java.util.HashMap;
import java.util.Map;

public class java_15526_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15526_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session with ID " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, "active");
            System.out.println("Session with ID " + sessionId + " started.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session with ID " + sessionId + " ended.");
        } else {
            System.out.println("Session with ID " + sessionId + " does not exist.");
        }
    }

    public String getSessionStatus(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session with ID " + sessionId + " does not exist.";
        }
    }
}