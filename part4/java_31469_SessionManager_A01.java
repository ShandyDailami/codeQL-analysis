import java.util.HashMap;
import java.util.Map;

public class java_31469_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31469_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String user, String sessionId) {
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void clearInvalidSessions() {
        sessionMap.entrySet().removeIf(entry -> !isValidSession(entry.getKey()));
    }
}