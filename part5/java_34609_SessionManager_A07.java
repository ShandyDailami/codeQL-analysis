import java.util.HashMap;
import java.util.Map;

public class java_34609_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_34609_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void deleteSession(String userId) {
        sessionMap.remove(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // create session
        sessionManager.createSession("user1", "session1");

        // get session
        String session = sessionManager.getSession("user1");
        System.out.println("Session: " + session);

        // delete session
        sessionManager.deleteSession("user1");
    }
}