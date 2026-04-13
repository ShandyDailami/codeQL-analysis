import java.util.HashMap;
import java.util.Map;

public class java_28290_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_28290_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists");
        }
        sessionMap.put(sessionId, "Started");
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
       
        }
        sessionMap.put(sessionId, "Ended");
    }

    public String getStatus(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with id " + sessionId + " exists");
        }
        return sessionMap.get(sessionId);
    }
}