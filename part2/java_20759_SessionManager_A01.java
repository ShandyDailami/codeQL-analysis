import java.util.HashMap;
import java.util.Map;

public class java_20759_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_20759_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String userID) {
        String sessionID = generateSessionID(); // Implementation for generating session ID
        sessionMap.put(sessionID, userID);
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void removeSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    // Simple session ID generator. In a real scenario, this should be more secure and complex
    private String generateSessionID() {
        return Long.toString(System.nanoTime());
    }
}