import java.util.HashMap;
import java.util.Map;

public class java_21055_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_21055_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (!sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, userName);
            System.out.println("Session started with ID: " + sessionId + " and User: " + userName);
        } else {
            System.out.println("Session already started with ID: " + sessionId + " and User: " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + " and User: " + userName);
        } else {
            System.out.println("No session found with ID: " + sessionId);
        }
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }
}