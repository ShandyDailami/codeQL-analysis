import java.util.HashMap;

public class java_19176_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_19176_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        // Generate a session token for the user
        String sessionToken = generateSessionToken(username);
        sessionMap.put(sessionToken, username);
        System.out.println("Started session for user: " + username);
    }

    public void endSession(String sessionToken) {
        // Remove the session from the session map
        String username = sessionMap.get(sessionToken);
        sessionMap.remove(sessionToken);
        System.out.println("Ended session for user: " + username);
    }

    public String getUsernameBySessionToken(String sessionToken) {
        // Return the username for the given session token
        return sessionMap.get(sessionToken);
    }

    private String generateSessionToken(String username) {
        // Generate a session token for the user
        return username + "_" + System.currentTimeMillis();
    }
}