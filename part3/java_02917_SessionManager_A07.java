import java.util.HashMap;

public class java_02917_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_02917_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = user + "_" + System.currentTimeMillis();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}