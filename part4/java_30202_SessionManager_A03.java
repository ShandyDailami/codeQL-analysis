import java.util.HashMap;
import java.util.UUID;

public class java_30202_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_30202_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, username);
        return uuid.toString();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public void updateSession(String sessionId, String newUsername) {
        sessionMap.replace(UUID.fromString(sessionId), newUsername);
    }
}