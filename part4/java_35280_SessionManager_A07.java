import java.util.HashMap;
import java.util.Map;

public class java_35280_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35280_SessionManager_A07() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        CustomSessionManager sessionManager = new CustomSessionManager();

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Created session with ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username of session: " + username);

        sessionManager.deleteSession(sessionId);
        System.out.println("Deleted session with ID: " + sessionId);

        if (sessionManager.isValidSession(sessionId)) {
            System.out.println("Session is valid: " + sessionId);
        } else {
            System.out.println("Session is not valid: " + sessionId);
        }
    }
}