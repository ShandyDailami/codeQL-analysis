import java.util.HashMap;
import java.util.Map;

public class java_15132_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_15132_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Generate a unique session id
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username in session: " + username);

        sessionManager.endSession(sessionId);
        System.out.println("Ended session: " + sessionId);
    }
}