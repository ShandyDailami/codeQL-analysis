import java.util.HashMap;
import java.util.Map;

public class java_07373_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07373_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session " + sessionId + " started by " + username);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session " + sessionId + " ended by " + username);
        } else {
            System.out.println("Error: No session " + sessionId + " found.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("A12_Session", "Alice");
        manager.startSession("A13_Session", "Bob");
        manager.startSession("A12_Session", "Charlie"); // Error: Session A12_Session already exists.
        manager.endSession("A12_Session");
        manager.endSession("A14_Session"); // Error: No session A14_Session found.
    }
}