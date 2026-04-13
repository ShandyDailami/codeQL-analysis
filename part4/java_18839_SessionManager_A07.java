import java.util.HashMap;

public class java_18839_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_18839_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
    }

    public void startSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String sessionId) {
        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session ended for user: " + userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }
}