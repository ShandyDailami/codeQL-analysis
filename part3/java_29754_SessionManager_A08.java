import java.util.HashMap;

public class java_29754_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_29754_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
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

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Session created with ID: " + sessionId);

        String username = sessionManager.getUsername(sessionId);
        System.out.println("Username associated with session ID: " + sessionId + " - " + username);

        sessionManager.deleteSession(sessionId);
        System.out.println("Session deleted with ID: " + sessionId);
    }
}