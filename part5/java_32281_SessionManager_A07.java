import java.util.HashMap;
import java.util.Map;

public class java_32281_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_32281_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName + " with Session ID: " + sessionId);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session found for Session ID: " + sessionId);
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found for Session ID: " + sessionId);
            return null;
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName + " with Session ID: " + sessionId);
        } else {
            System.out.println("No session found for Session ID: " + sessionId);
        }
    }

    private String generateSessionId() {
        // This is a placeholder. In a real-world application, a secure method of generating session IDs would be used.
        return "A07_AuthFailure";
    }
}