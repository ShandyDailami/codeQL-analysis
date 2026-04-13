import java.util.HashMap;

public class java_27576_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_27576_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}