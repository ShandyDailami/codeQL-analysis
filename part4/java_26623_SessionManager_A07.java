import java.util.HashMap;
import java.util.Map;

public class java_26623_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26623_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Creating a new session
        String sessionId = "session1";
        String userId = "user1";
        sessionManager.createSession(sessionId, userId);

        // Getting the user id from the session
        String user = sessionManager.getUserId(sessionId);
        System.out.println("User in session: " + user); // Outputs: User in session: user1

        // Ending the session
        sessionManager.endSession(sessionId);

        // Attempt to get the user in the session after ending it.
        // This should return null as the session has been ended.
        user = sessionManager.getUserId(sessionId);
        System.out.println("User in session after ending: " + user); // Outputs: User in session after ending: null
    }
}