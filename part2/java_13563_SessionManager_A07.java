import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_13563_SessionManager_A07 {
    private Map<UUID, String> sessionMap;

    public java_13563_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userName);
        return sessionId.toString();
    }

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserName(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(UUID sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean authenticate(UUID sessionId, String userName) {
        if (!isValidSession(sessionId)) {
            return false;
        }

        String storedUserName = sessionMap.get(sessionId);
        return storedUserName.equals(userName);
    }
}