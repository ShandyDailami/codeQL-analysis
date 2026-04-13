import java.util.HashMap;
import java.util.Map;

public class java_31053_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_31053_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void changeUsername(String sessionId, String newUsername) {
        String oldUsername = sessionMap.get(sessionId);
        if (oldUsername != null) {
            sessionMap.put(sessionId, newUsername);
        }
    }
}