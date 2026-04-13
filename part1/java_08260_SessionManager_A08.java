import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_08260_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_08260_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String sessionId = manager.createSession("John");
        System.out.println("Created session with id: " + sessionId);

        String username = manager.getUsername(sessionId);
        System.out.println("Username: " + username);

        manager.deleteSession(sessionId);
        System.out.println("Deleted session with id: " + sessionId);
    }
}