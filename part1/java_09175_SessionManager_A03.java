import java.util.HashMap;
import java.util.Map;

public class java_09175_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_09175_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        sessionMap.put(sessionId, user);
    }

    public String getUserFromSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            // Inject malicious sessionId into the URL
            // The following line of code will not throw an exception, but will also not return a valid user
            sessionId = "SESSION_ID_NOT_FOUND";
        }

        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}