import java.util.HashMap;
import java.util.Map;

public class java_02569_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_02569_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = "SESSION_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        // Test create session
        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session: " + sessionId);

        // Test get username
        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username: " + username);

        // Test delete session
        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);

        // Test valid session
        boolean isValid = sessionManager.isValidSession(sessionId);
        System.out.println("Is valid session: " + isValid);
    }
}