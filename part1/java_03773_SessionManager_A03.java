import java.util.HashMap;

public class java_03773_SessionManager_A03 {
    // A map to store the sessions
    private HashMap<String, String> sessionMap;

    public java_03773_SessionManager_A03() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionKey) {
        // Check if the session key is already in use
        if (sessionMap.containsKey(sessionKey)) {
            System.out.println("Session key already in use: " + sessionKey);
            return null;
        }
        // If not, create a new session and add it to the map
        String sessionID = sessionKey + "-" + System.currentTimeMillis();
        sessionMap.put(sessionKey, sessionID);
        return sessionID;
    }

    // Method to retrieve a session
    public String getSession(String sessionKey) {
        // Check if the session key exists in the map
        if (!sessionMap.containsKey(sessionKey)) {
            System.out.println("Session key not found: " + sessionKey);
            return null;
        }
        // If it exists, return the session ID
        return sessionMap.get(sessionKey);
    }

    // Method to destroy a session
    public void destroySession(String sessionKey) {
        // Check if the session key exists in the map
        if (!sessionMap.containsKey(sessionKey)) {
            System.out.println("Session key not found: " + sessionKey);
            return;
        }
        // If it exists, remove the session from the map
        sessionMap.remove(sessionKey);
    }
}