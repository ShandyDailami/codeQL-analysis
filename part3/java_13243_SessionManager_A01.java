import java.util.HashMap;

public class java_13243_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_13243_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with ID: " + sessionId);
        } else {
            System.out.println("Error: Session with ID: " + sessionId + " already exists.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        } else {
            System.out.println("Error: No session with ID: " + sessionId + " found.");
        }
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Error: No session with ID: " + sessionId + " found.");
            return null;
        }
    }
}