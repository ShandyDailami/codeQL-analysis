import java.util.HashMap;

public class java_26546_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_26546_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists with id: " + sessionId);
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session started with id: " + sessionId + " for user: " + username);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with id: " + sessionId + " for user: " + username);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }

    public void checkSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            System.out.println("Session exists with id: " + sessionId + " for user: " + username);
        } else {
            System.out.println("No session exists with id: " + sessionId);
        }
    }
}