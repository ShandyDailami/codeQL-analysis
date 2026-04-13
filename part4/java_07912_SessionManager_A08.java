import java.util.HashMap;
import java.util.Map;

public class java_07912_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_07912_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis(); // this is a unique session ID
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}