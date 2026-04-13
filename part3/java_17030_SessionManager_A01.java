import java.util.HashMap;

public class java_17030_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_17030_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to end a session
    public String endSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            return userName;
        } else {
            return null;
        }
    }

    // Method to get user name from a session
    public String getUserNameFromSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}