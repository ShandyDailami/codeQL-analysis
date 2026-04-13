import java.util.HashMap;
import java.util.Map;

public class java_36258_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_36258_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId, String sessionId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1", "session1");
        System.out.println(sessionManager.getUserId(sessionId)); // prints user1

        sessionManager.endSession("session1");
        System.out.println(sessionManager.getUserId(sessionId)); // prints null
    }
}