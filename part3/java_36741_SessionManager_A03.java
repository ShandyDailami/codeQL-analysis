import java.util.HashMap;

public class java_36741_SessionManager_A03 {
    // Define a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Initialize the session map
    public java_36741_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionID) {
        sessionMap.put(sessionID, sessionID);
        return sessionID;
    }

    // Method to retrieve the data for a given session
    public String getSessionData(String sessionID) {
        return sessionMap.get(sessionID);
    }
}