import java.util.HashMap;
import java.util.Map;

public class java_27724_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27724_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.startSession("session1", "user1");
        System.out.println("UserID: " + manager.getUserId("session1"));
        manager.endSession("session1");
        System.out.println("Session valid: " + manager.isSessionValid("session1"));
    }
}