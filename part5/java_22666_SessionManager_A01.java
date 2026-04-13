import java.util.HashMap;
import java.util.Map;

public class java_22666_SessionManager_A01 {
    // Session data is stored in a HashMap.
    private Map<String, String> sessionData;

    public java_22666_SessionManager_A01() {
        sessionData = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String data) {
        sessionData.put(sessionId, data);
    }

    // Method to get a session
    public String getSession(String sessionId) {
        return sessionData.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }
}