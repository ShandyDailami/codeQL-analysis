import java.util.HashMap;
import java.util.Map;

public class java_33421_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_33421_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session not found");
            return null;
        }

        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserId(String sessionId, String newUserId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session not found");
            return;
        }

        sessionMap.replace(sessionId, newUserId);
    }
}