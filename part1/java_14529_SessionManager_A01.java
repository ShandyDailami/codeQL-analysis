import java.util.HashMap;
import java.util.Map;

public class java_14529_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_14529_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void addUserToSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId)) {
            String currentUser = sessionMap.get(sessionId);
            sessionMap.replace(sessionId, currentUser + ", " + user);
        }
    }

    public void removeUserFromSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId)) {
            String currentUsers = sessionMap.get(sessionId);
            sessionMap.replace(sessionId, currentUsers.replaceAll(", " + user, ""));
        }
    }

    private String generateSessionId() {
        // This is a dummy implementation. In a real-world scenario, sessionId would be generated randomly.
        return "sessionId";
    }
}