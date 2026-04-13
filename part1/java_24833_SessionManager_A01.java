import java.util.HashMap;

public class java_24833_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_24833_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return "Invalid session ID";
        }
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        if (sessions.containsKey(sessionId)) {
            sessions.put(sessionId, userId);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public void secureOperation(String sessionId, String expectedUserId) {
        if (sessions.containsKey(sessionId)) {
            if (sessions.get(sessionId).equals(expectedUserId)) {
                System.out.println("Secure operation performed successfully");
            } else {
                System.out.println("Invalid user");
            }
        } else {
            System.out.println("Invalid session ID");
        }
    }
}