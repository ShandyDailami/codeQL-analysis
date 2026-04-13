import java.util.HashMap;
import java.util.Map;

public class java_12008_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12008_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("session1", "user1");
        System.out.println(sessionManager.getUserName("session1")); // user1

        sessionManager.startSession("session2", "user2");
        System.out.println(sessionManager.getUserName("session2")); // user2

        sessionManager.endSession("session1");
        System.out.println(sessionManager.getUserName("session1")); // null (session has ended)
    }
}