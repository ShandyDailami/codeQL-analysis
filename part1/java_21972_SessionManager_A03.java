import java.util.HashMap;

public class java_21972_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_21972_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}