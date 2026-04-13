import java.util.HashMap;
import java.util.Map;

public class java_05203_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_05203_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserId(String oldSessionId, String newSessionId, String newUserId) {
        if(sessionMap.containsKey(oldSessionId)) {
            sessionMap.remove(oldSessionId);
            sessionMap.put(newSessionId, sessionMap.get(oldSessionId));
        } else {
            System.out.println("Invalid session Id provided.");
        }
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}