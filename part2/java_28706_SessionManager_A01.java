import java.util.HashMap;

public class java_28706_SessionManager_A01 {

    private HashMap<String, String> sessionMap;

    public java_28706_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
        System.out.println("Session started with ID: " + sessionId + " User: " + user);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public String getUserBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }
}