import java.util.HashMap;
import java.util.Map;

public class java_37303_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_37303_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // generate a unique session id for each session
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user: " + username + " with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session for user: " + username + " with ID: " + sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("John");
        manager.startSession("Jane");
        manager.endSession("John");
    }
}