import java.util.HashMap;

public class java_35428_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_35428_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a very basic example of a session ID generator.
        // In a real application, you would want to use a more secure method.
        return String.valueOf(System.currentTimeMillis());
    }
}