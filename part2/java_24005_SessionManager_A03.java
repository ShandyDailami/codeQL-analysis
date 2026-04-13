import java.util.HashMap;
import java.util.Map;

public class java_24005_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_24005_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for user: " + user);
        } else {
            sessionMap.put(sessionId, user);
        }
    }

    public String getUserBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No session found for session id: " + sessionId);
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("No session found for session id: " + sessionId);
        }
    }
}