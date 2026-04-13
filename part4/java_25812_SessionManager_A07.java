import java.util.HashMap;

public class java_25812_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_25812_SessionManager_A07() {
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

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is just a simple example. You should not use this in a real-world application.
        return "sessionId";
    }
}