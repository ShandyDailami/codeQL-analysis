import java.util.HashMap;
import java.util.Map;

public class java_25288_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25288_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session with ID " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, "ACTIVE");
            System.out.println("Session with ID " + sessionId + " started.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            if (sessionMap.get(sessionId).equals("ACTIVE")) {
                sessionMap.put(sessionId, "INACTIVE");
                System.out.println("Session with ID " + sessionId + " ended.");
            } else {
                System.out.println("Error: Session with ID " + sessionId + " does not exist or is not currently active.");
            }
        } else {
            System.out.println("Error: Session with ID " + sessionId + " does not exist.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("session1");
        manager.startSession("session2");
        manager.endSession("session1");
        manager.endSession("session3");
    }
}