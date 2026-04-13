import java.util.HashMap;
import java.util.Map;

public class java_21396_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_21396_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String value) {
        sessionMap.put(sessionId, value);
    }

    public String getValueFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}