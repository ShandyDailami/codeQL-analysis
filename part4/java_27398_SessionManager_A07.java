import java.util.HashMap;
import java.util.Map;

public class java_27398_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27398_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Generate a random session ID for the user
        String sessionID = generateSessionID(username);
        sessionMap.put(sessionID, username);
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    private String generateSessionID(String username) {
        // Implement a logic to generate a session ID based on username
        return username;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("user1");
        String session1 = sessionManager.getSession("user1");
        System.out.println("Session 1: " + session1);

        sessionManager.startSession("user2");
        String session2 = sessionManager.getSession("user2");
        System.out.println("Session 2: " + session2);

        sessionManager.endSession("user1");
        String session3 = sessionManager.getSession("user1");
        System.out.println("Session 3: " + session3);
    }
}