import java.util.HashMap;
import java.util.Map;

public class java_25400_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_25400_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isSessionValid(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        String userID = "alice";
        String sessionID = sessionManager.createSession(userID);
        System.out.println("Created session: " + sessionID);

        // Test session validation
        if (sessionManager.isSessionValid(sessionID)) {
            String user = sessionManager.getUserFromSession(sessionID);
            System.out.println("User in session: " + user);
        } else {
            System.out.println("Session not valid.");
        }

        // End session
        sessionManager.endSession(sessionID);

        // Test session validation after session end
        if (!sessionManager.isSessionValid(sessionID)) {
            System.out.println("Session ended successfully.");
        } else {
            System.out.println("Failed to end session.");
        }
    }
}