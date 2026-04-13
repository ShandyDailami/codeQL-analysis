import java.util.HashMap;

public class java_33917_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_33917_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void integrityCheck(String sessionId) {
        String sessionData = sessionMap.get(sessionId);
        if (sessionData == null || sessionData.equals("")) {
            throw new SecurityException("Session integrity failure: session data is null or empty");
        }
    }
}