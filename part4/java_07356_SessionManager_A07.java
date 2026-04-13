import java.util.HashMap;

public class java_07356_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_07356_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation, it's not secure for production use
        return String.valueOf(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username in session: " + username);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}