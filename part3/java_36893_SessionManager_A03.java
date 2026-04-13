import java.util.HashMap;
import java.util.Map;

public class java_36893_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36893_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id cannot be null or empty");
        }

        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("A session with this id already exists. Please choose a different session id.");
        }

        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id cannot be null or empty");
        }

        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("No session with this id exists. No action was taken.");
        }

        sessionMap.put(sessionId, "Inactive");
    }

    public String getSessionStatus(String sessionId) {
        if (sessionId == null || sessionId.equals("")) {
            throw new IllegalArgumentException("Session id cannot be null or empty");
        }

        return sessionMap.get(sessionId);
    }
}