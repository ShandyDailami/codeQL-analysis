import java.util.HashMap;

public class java_34416_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_34416_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}