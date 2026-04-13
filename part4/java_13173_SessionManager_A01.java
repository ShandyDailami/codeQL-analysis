import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_13173_SessionManager_A01 {
    private Map<UUID, String> sessionMap;

    public java_13173_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, user);
        return sessionId.toString();
    }

    public String getUser(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("User1");
        System.out.println("Created session with ID: " + sessionId);

        String user = sessionManager.getUser(sessionId);
        System.out.println("Retrieved user: " + user);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session with ID: " + sessionId);
    }
}