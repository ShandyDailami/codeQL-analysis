import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_36375_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_36375_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String clientId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, clientId);
        System.out.println("Created session: " + sessionId + " for client: " + clientId);
        return sessionId;
    }

    public String getClientId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Validated session: " + sessionId + " for client: " + sessionMap.get(sessionId));
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Invalid session: " + sessionId);
            return null;
        }
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String clientId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Removed session: " + sessionId + " for client: " + clientId);
        } else {
            System.out.println("No session to remove: " + sessionId);
        }
    }
}