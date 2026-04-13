import java.util.HashMap;
import java.util.Map;

public class java_41331_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_41331_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();
        String session = sessionManager.createSession("user1");
        System.out.println("Created session: " + session);
        String user = sessionManager.getUser(session);
        System.out.println("User in session: " + user);
        sessionManager.destroySession(session);
        System.out.println("Destroyed session: " + session);
    }
}