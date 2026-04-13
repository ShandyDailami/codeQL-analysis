import java.util.HashMap;
import java.util.Map;

public class java_09308_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09308_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        String user = sessionManager.getUserFromSession(sessionId);
        System.out.println("Retrieved user from session: " + user);

        sessionManager.destroySession(sessionId);
        System.out.println("Destroyed session: " + sessionId);
    }
}