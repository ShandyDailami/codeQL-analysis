import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_17668_SessionManager_A07 {
    private Map<UUID, String> sessionMap;

    public java_17668_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userName);
        return sessionId.toString();
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("User1");
        System.out.println("Created session ID: " + sessionId);

        String userName = sessionManager.getUserName(sessionId);
        System.out.println("User name: " + userName);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session ID: " + sessionId);
    }
}