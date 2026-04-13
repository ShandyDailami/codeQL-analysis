import java.util.HashMap;
import java.util.Map;

public class java_34229_SessionManager_A03 {
    private Map<String, String> sessionStorage;

    public java_34229_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionStorage.containsKey(sessionId)) {
            return sessionStorage.get(sessionId);
        }
        return null;
    }

    public void setSession(String sessionId, String sessionValue) {
        sessionStorage.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}