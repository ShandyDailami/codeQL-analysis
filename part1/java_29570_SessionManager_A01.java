import java.util.HashMap;
import java.util.Map;

public class java_29570_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_29570_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Use a UUID for session id
        sessionMap.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session not found or expired");
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session for user " + username + " with ID " + sessionId);
        } else {
            System.out.println("Session not found or expired");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("Alice");
        sessionManager.startSession("Bob");
        sessionManager.startSession("Charlie");
        System.out.println("Current users: " + sessionManager.getUser(sessionManager.sessionMap.keySet().iterator().next()));
        sessionManager.endSession(sessionManager.sessionMap.keySet().iterator().next());
        System.out.println("Current users: " + sessionManager.getUser(sessionManager.sessionMap.keySet().iterator().next()));
    }
}