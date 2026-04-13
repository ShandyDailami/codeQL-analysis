import java.util.HashMap;
import java.util.UUID;

public class java_13417_SessionManager_A08 {
    private HashMap<UUID, String> sessionData;

    public java_13417_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public UUID startSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionData.put(sessionId, userName);
        return sessionId;
    }

    public String getUserNameFromSession(UUID sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            System.out.println("Invalid session ID");
            return null;
        }
    }

    public void endSession(UUID sessionId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.remove(sessionId);
        } else {
            System.out.println("Invalid session ID");
        }
    }
}