import java.util.HashMap;
import java.util.Map;

public class java_00579_SessionManager_A08 {

    // The HashMap that will be used as the session storage
    private Map<String, String> storage;

    // A simple constructor
    public java_00579_SessionManager_A08() {
        storage = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId) {
        storage.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        return storage.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        storage.remove(sessionId);
    }
}