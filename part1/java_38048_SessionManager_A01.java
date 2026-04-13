import java.util.HashMap;

public class java_38048_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_38048_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    //Method to start a session
    public String startSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    //Method to validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    //Method to terminate a session
    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }
}