import java.util.HashMap;
import java.util.Map;

public class java_41627_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_41627_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
        return "Session created with ID: " + sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public String deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session with ID: " + sessionId + " deleted";
    }
}