import java.util.HashMap;

public class java_09554_SessionManager_A08 {
    private HashMap<String, Object> sessionMap;

    public java_09554_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
    }

    public void stopSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkIntegrity() {
        for(String sessionId : sessionMap.keySet()) {
            if(sessionMap.get(sessionId) == null) {
                System.out.println("Integrity failure detected for session ID: " + sessionId);
                invalidateSession(sessionId);
            }
        }
    }
}