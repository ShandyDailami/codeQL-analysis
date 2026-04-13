import java.util.HashMap;

public class java_13777_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_13777_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation of session id generation. In a real-world application, 
        // you should use a more secure and complex method.
        return "A01_BrokenAccessControl_Session_" + System.nanoTime();
    }
}