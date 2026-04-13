import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_31731_SessionManager_A07 {

    private Map<UUID, String> sessionMap;

    public java_31731_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public UUID createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public void deleteSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionData(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        UUID sessionId = sessionManager.createSession("Session data");
        System.out.println("Created session: " + sessionId);

        String sessionData = sessionManager.getSessionData(sessionId);
        System.out.println("Session data: " + sessionData);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}