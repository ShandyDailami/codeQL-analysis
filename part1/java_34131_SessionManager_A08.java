import java.util.HashMap;
import java.util.Map;

public class java_34131_SessionManager_A08 {
    // Using HashMap for session management
    private Map<String, String> sessionMap;

    public java_34131_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session Already Exists: " + sessionId);
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("New Session Started: " + sessionId + " - " + userId);
        }
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session Ended: " + sessionId + " - " + userId);
        } else {
            System.out.println("No Such Session Exists: " + sessionId);
        }
    }

    // Method to get userId associated with the sessionId
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to check whether a session exists or not
    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("s1", "u1");
        sessionManager.startSession("s2", "u2");
        sessionManager.startSession("s3", "u3");

        System.out.println("Active Sessions: " + sessionManager.isSessionActive("s1"));
        System.out.println("Active Sessions: " + sessionManager.isSessionActive("s2"));
        System.out.println("Active Sessions: " + sessionManager.isSessionActive("s4"));

        System.out.println("User In Session s1: " + sessionManager.getUserId("s1"));

        sessionManager.endSession("s1");
        System.out.println("Active Sessions: " + sessionManager.isSessionActive("s1"));
    }
}