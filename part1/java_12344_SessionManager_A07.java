import java.util.HashMap;
import java.util.Map;

public class java_12344_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12344_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username from session: " + username);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);

        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session: " + isValid);
    }
}