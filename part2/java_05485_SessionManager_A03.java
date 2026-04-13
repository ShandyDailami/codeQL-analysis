import java.util.HashMap;

public class java_05485_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_05485_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = userName + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}