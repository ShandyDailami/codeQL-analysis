import java.util.HashMap;
import java.util.Map;

public class java_08638_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_08638_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userID) {
        String sessionID = generateSessionID();
        sessionMap.put(sessionID, userID);
        System.out.println("Started session with ID: " + sessionID);
    }

    public void endSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            String userID = sessionMap.get(sessionID);
            sessionMap.remove(sessionID);
            System.out.println("Ended session for user with ID: " + userID);
        } else {
            System.out.println("Session not found!");
        }
    }

    private String generateSessionID() {
        // Simulating a security-sensitive operation.
        // You can use a secure random generation mechanism here.
        return "SessionID-" + System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("User1");
        manager.startSession("User2");
        manager.endSession(manager.sessionMap.keySet().iterator().next());
    }
}