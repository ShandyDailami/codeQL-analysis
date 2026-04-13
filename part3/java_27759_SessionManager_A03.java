import java.util.HashMap;
import java.util.Map;

public class java_27759_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_27759_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String user) throws Exception {
        if (sessionId == null || user == null) {
            throw new Exception("Session ID and User cannot be null");
        }
        sessionMap.put(sessionId, user);
    }

    public String getUser(String sessionId) throws Exception {
        if (sessionId == null) {
            throw new Exception("Session ID cannot be null");
        }
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) throws Exception {
        if (sessionId == null) {
            throw new Exception("Session ID cannot be null");
        }
        sessionMap.remove(sessionId);
    }
}