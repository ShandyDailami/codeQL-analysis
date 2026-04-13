import java.util.HashMap;
import java.util.Map;

public class java_27238_SessionManager_A03 {
    private Map<String, String> sessions;

    public java_27238_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessions.put(sessionId, userName);
    }

    public String getSessionUserName(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}