import java.util.HashMap;

public class java_29597_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_29597_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    public String createSession(String userId) {
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}