import java.util.HashMap;

public class java_32539_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_32539_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        System.out.println("Session started with ID: " + sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
       
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found with ID: " + sessionId);
            return null;
        }
    }
}