import java.util.HashMap;

public class java_17969_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_17969_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        // Generate a unique session ID
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Associate the session ID with the username
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    public String getUsername(String sessionID) {
        // Get the username associated with the session ID
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        // Remove the session from the session map
        sessionMap.remove(sessionID);
    }
}