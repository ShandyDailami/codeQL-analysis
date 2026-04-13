import java.util.HashMap;
import java.util.Map;

public class java_04130_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04130_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("User1", "Session1");

        // Check if the session is valid
        if (sessionManager.isValidSession("Session1")) {
            // Get the user who is in this session
            String user = sessionManager.getSessionUser("Session1");
            System.out.println("User is: " + user); // Output: User is: User1
        }

        // End the session
        sessionManager.endSession("Session1");

        // Check if the session is valid
        if (!sessionManager.isValidSession("Session1")) {
            System.out.println("Session is not valid"); // Output: Session is not valid
        }
    }
}