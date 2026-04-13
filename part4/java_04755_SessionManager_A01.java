import java.util.HashMap;
import java.util.Map;

public class java_04755_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_04755_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateUserId(String sessionId, String newUserId) {
        if (isValidSession(sessionId)) {
            String oldUserId = getUserId(sessionId);
            sessionMap.put(sessionId, newUserId);
            System.out.println("User ID updated from " + oldUserId + " to " + newUserId);
        } else {
            System.out.println("Invalid session Id");
        }
    }
}