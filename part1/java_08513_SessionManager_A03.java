import java.util.HashMap;
import java.util.Map;

public class java_08513_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_08513_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id.");
        }
    }

    public void destroySession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Invalid session id.");
        }
    }
}