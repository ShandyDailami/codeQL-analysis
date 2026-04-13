import java.util.HashMap;

public class java_16290_SessionManager_A03 {
    private HashMap<String, String> sessionStorage;

    public java_16290_SessionManager_A03() {
        sessionStorage = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionStorage.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionStorage.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionStorage.remove(sessionId);
    }
}