import java.util.HashMap;
import java.util.Map;

public class java_13335_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_13335_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserNameBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateUserNameBySessionId(String sessionId, String userName) {
        sessionMap.replace(sessionId, userName);
    }

    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}