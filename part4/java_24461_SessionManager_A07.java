import java.util.HashMap;

public class java_24461_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_24461_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session for a user
        String username = "User1";
        String sessionId = "session1";
        sessionManager.createSession(username, sessionId);

        // Getting the username from a session
        String usernameFromSession = sessionManager.getUsername(sessionId);
        System.out.println("Username from session: " + usernameFromSession);

        // Deleting a session
        sessionManager.deleteSession(sessionId);
    }
}