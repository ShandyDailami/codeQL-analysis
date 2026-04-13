import java.util.HashMap;
import java.util.Map;

public class java_14728_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_14728_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidUser(String userId) {
        for (String sessionId : sessionMap.values()) {
            if (sessionId.equals(userId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidUserAndSession(String sessionId, String userId) {
        return isValidSession(sessionId) && isValidUser(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        sessionManager.startSession("session2", "user2");

        System.out.println(sessionManager.getUserId("session1")); // should print user1
        System.out.println(sessionManager.getUserId("session2")); // should print user2

        sessionManager.endSession("session1");

        System.out.println(sessionManager.isValidSession("session1")); // should print false
        System.out.println(sessionManager.isValidUser("user1")); // should print true
        System.out.println(sessionManager.isValidUserAndSession("session2", "user2")); // should print true
    }
}