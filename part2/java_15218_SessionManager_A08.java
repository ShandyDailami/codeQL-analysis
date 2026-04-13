import java.util.HashMap;

public class java_15218_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_15218_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        System.out.println("Session " + sessionId + " started for user " + username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + username);
    }

    private String generateSessionId() {
        // This is a simple example, in a real-world application, you would probably use UUID
        // or some other method to generate a unique ID
        return System.currentTimeMillis() + "_" + (int) (Math.random() * 10000);
    }
}