import java.util.HashMap;
import java.util.Map;

public class java_35641_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35641_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // start a session for user "123"
        sessionManager.startSession("123", "session123");

        // get the session for user "123"
        String sessionId = sessionManager.getSession("123");
        System.out.println("Session ID: " + sessionId);

        // end the session for user "123"
        sessionManager.endSession("123");
    }
}