import java.util.HashMap;
import java.util.Map;

public class java_05623_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05623_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = Integer.toString(username.hashCode());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("alice");
        System.out.println("Created session: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Retrieved username: " + username);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}