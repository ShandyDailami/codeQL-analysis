import java.util.HashMap;

public class java_28201_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_28201_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Started session with ID: " + sessionId + ", for user: " + userId);
        } else {
            System.out.println("Failed to start session. Session with ID: " + sessionId + " already exists.");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with ID: " + sessionId + ", for user: " + userId);
        } else {
            System.out.println("Failed to end session. Session with ID: " + sessionId + " does not exist.");
        }
    }

    public String getUserForSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Session with ID: " + sessionId + " does not exist.");
            return null;
        }
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}