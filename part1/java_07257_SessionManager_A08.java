import java.util.HashMap;

public class java_07257_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_07257_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Retrieve session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Destroy session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if session is valid
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}