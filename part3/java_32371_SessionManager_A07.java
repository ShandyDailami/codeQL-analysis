import java.util.HashMap;
import java.util.Map;

public class java_32371_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_32371_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session with ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username from session: " + username);

        sessionManager.destroySession(sessionId);
        System.out.println("Session destroyed with ID: " + sessionId);

        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is Valid Session? " + isValid);
    }
}