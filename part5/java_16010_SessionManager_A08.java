import java.util.HashMap;

public class java_16010_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_16010_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Started session " + sessionId + " for user " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Ended session " + sessionId + " for user " + userName);
    }

    private String generateSessionId() {
        // This is a placeholder, you'd want to replace this with a more robust session ID generation
        return String.valueOf(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("Alice");
        manager.startSession("Bob");
        manager.endSession("Alice");
        manager.startSession("Charlie");
    }
}