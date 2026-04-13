import java.util.HashMap;

public class java_00668_SessionManager_A01 {

    private HashMap<String, String> sessionData;

    public java_00668_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionData.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public void updateSessionUserId(String sessionId, String newUserId) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.replace(sessionId, newUserId);
        }
    }
}