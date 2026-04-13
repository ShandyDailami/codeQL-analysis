import java.util.HashMap;
import java.util.Map;

public class java_05382_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05382_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        this.sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return this.sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        this.sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a session for user 'A'
        String sessionId1 = "session1";
        String userId1 = "A";
        sessionManager.createSession(sessionId1, userId1);

        // Getting the user from the session
        String userFromSession = sessionManager.getUserFromSession(sessionId1);
        System.out.println("User from session: " + userFromSession);  // Output: User from session: A

        // Deleting the session
        sessionManager.deleteSession(sessionId1);

        // Trying to get the user from the session after deletion
        userFromSession = sessionManager.getUserFromSession(sessionId1);
        System.out.println("User from session after deletion: " + userFromSession);  // Output: User from session after deletion: null
    }
}