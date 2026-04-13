import java.util.HashMap;

public class java_26689_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_26689_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void checkIntegrity(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            String userId = sessions.get(sessionId);
            if (userId == null || userId.isEmpty()) {
                System.out.println("A08_IntegrityFailure: Session " + sessionId + " is invalidated due to a null or empty userId");
            }
        } else {
            System.out.println("A08_IntegrityFailure: Session " + sessionId + " not found");
        }
    }
}