import java.util.HashMap;

public class java_10922_SessionManager_A07 {

    // A simple in-memory store for sessions
    private HashMap<String, String> sessionMap;

    public java_10922_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a new session
    public String startSession(String userName) {
        String sessionId = null;
        if (sessionMap.size() == 0) {
            sessionId = "A07_AuthFailure001";
        } else {
            sessionId = "A07_AuthFailure002";
        }
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean isSessionValid(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to get the user name associated with a session
    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }
}