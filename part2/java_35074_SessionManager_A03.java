import java.util.HashMap;
import java.util.Map;

public class java_35074_SessionManager_A03 {
    // A simple in-memory store for session data
    private Map<String, Object> sessionMap;

    public java_35074_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method for starting a session
    public void startSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
        System.out.println("Started session with ID: " + sessionId);
    }

    // Method for retrieving a session
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method for ending a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
        System.out.println("Ended session with ID: " + sessionId);
    }
}