import java.util.HashMap;
import java.util.Map;

public class java_29338_SessionManager_A03 {
    // Step 1: Declare a HashMap to store the sessions
    private Map<String, String> sessionMap;

    // Step 2: Constructor to initialize the session map
    public java_29338_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Step 3: Create a method to add a session
    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    // Step 4: Create a method to retrieve session data
    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Step 5: Create a method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}