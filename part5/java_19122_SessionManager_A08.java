import java.util.HashMap;
import java.util.Map;

public class java_19122_SessionManager_A08 {
    private Map<String, Object> sessionData;

    public java_19122_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    public void startSession(String sessionId, Object data) {
        sessionData.put(sessionId, data);
    }

    public Object getSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public void updateSession(String sessionId, Object data) {
        if (sessionData.containsKey(sessionId)) {
            sessionData.put(sessionId, data);
        } else {
            System.out.println("No session found with id: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionData.containsKey(sessionId);
    }
}