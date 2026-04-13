import java.util.HashMap;
import java.util.Map;

public class java_05533_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05533_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        }
        sessionMap.put(sessionId, "");
    }

    public void updateSession(String sessionId, String data) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found");
        }
        sessionMap.put(sessionId, data);
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("No session found");
        }
        sessionMap.remove(sessionId);
    }

    public void cleanUp() {
        sessionMap.clear();
    }
}