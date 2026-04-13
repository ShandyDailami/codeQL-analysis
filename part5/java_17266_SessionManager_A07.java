import java.util.HashMap;

public class java_17266_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_17266_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void logout(String sessionId) {
        deleteSession(sessionId);
    }
}