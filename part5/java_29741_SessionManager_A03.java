import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_29741_SessionManager_A03 {
    private Map<UUID, String> sessions;
    private Map<String, String> weakPasswords;

    public java_29741_SessionManager_A03() {
        sessions = new HashMap<>();
        weakPasswords = new HashMap<>();

        // Add some weak passwords for testing
        weakPasswords.put("password", "weak");
    }

    public String createSession(String password) {
        if (!isPasswordWeak(password)) {
            return null;
        }

        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, password);
        return sessionId.toString();
    }

    public String getSessionPassword(String sessionId) {
        return sessions.get(UUID.fromString(sessionId));
    }

    public boolean destroySession(String sessionId) {
        if (sessions.containsKey(UUID.fromString(sessionId))) {
            sessions.remove(UUID.fromString(sessionId));
            return true;
        }
        return false;
    }

    private boolean isPasswordWeak(String password) {
        return weakPasswords.containsKey(password);
    }
}