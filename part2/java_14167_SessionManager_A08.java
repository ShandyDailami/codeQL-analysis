import java.util.HashMap;
import java.util.UUID;

public class java_14167_SessionManager_A08 {
    private HashMap<UUID, String> sessionMap;

    public java_14167_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, user);
        return uuid.toString();
    }

    public String getUserFromSession(String sessionId) {
        UUID uuid = UUID.fromString(sessionId);
        if (sessionMap.containsKey(uuid)) {
            return sessionMap.get(uuid);
        } else {
            return "Invalid session";
        }
    }

    public void checkSessionIntegrity(String sessionId) {
        UUID uuid = UUID.fromString(sessionId);
        if (!sessionMap.containsKey(uuid)) {
            System.out.println("Session integrity check failed: Invalid session");
        } else {
            System.out.println("Session integrity check passed");
        }
    }
}