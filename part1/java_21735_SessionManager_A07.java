import java.util.HashMap;
import java.util.Map;

public class java_21735_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_21735_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists!");
        } else {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId);
        } else {
            System.out.println("Session does not exist!");
        }
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Session does not exist!";
        }
    }
}