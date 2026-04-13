import java.util.HashMap;

public class java_23804_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_23804_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for id: " + sessionId);
        } else {
            sessionMap.put(sessionId, "Active");
            System.out.println("Session started with id: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, "Inactive");
            System.out.println("Session ended with id: " + sessionId);
        } else {
            System.out.println("No session found for id: " + sessionId);
        }
    }

    public String getSessionStatus(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "No session found for id: " + sessionId;
        }
    }
}