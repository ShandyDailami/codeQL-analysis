import java.util.HashMap;

public class java_29414_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_29414_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = generateSessionID();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    private String generateSessionID() {
        // This is a placeholder for a more complex session generation logic.
        // In a real-world scenario, you would likely use UUID or similar to generate a unique session ID.
        return "sessionID";
    }
}