import java.util.HashMap;
import java.util.Map;

public class java_14302_SessionManager_A01 {

    // This is a simple in-memory session storage
    private Map<String, String> sessionStorage;

    public java_14302_SessionManager_A01() {
        this.sessionStorage = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionStorage.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }

}