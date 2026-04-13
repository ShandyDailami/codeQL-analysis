import java.util.HashMap;
import java.util.Map;

public class java_20259_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_20259_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void enforceBrokenAccessControl(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new IllegalArgumentException("Invalid session: " + sessionId);
        }

        String userName = getUserName(sessionId);

        // Here, we're just logging the username, but in a real application,
        // we would likely enforce access control policies based on the user's role.
        System.out.println("Access granted to user: " + userName);
    }
}