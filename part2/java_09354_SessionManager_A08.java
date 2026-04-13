import java.util.HashMap;
import java.util.Map;

public class java_09354_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09354_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        System.out.println("Started session with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with ID: " + sessionId + ", username: " + username);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public String getUsername(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.startSession("Alice");
        manager.startSession("Bob");
        manager.startSession("Charlie");
        manager.endSession("Bob");
        manager.endSession("Charlie");
        manager.endSession("Bobby");
        System.out.println("Username Alice: " + manager.getUsername("Alice"));
        System.out.println("Username Bob: " + manager.getUsername("Bob"));
        System.out.println("Username Charlie: " + manager.getUsername("Charlie"));
    }
}