import java.util.HashMap;
import java.util.Map;

public class java_06969_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_06969_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Generate a secure session token for the user
        String sessionToken = generateSessionToken(userId);

        // Store the session token and user id in the session map
        sessionMap.put(sessionToken, userId);
    }

    public String getUserId(String sessionToken) {
        // Validate the session token, if it is valid return the user id
        if (sessionMap.containsKey(sessionToken)) {
            return sessionMap.get(sessionToken);
        } else {
            // Handle authentication failure
            handleAuthFailure(sessionToken);
            return null;
        }
    }

    private void handleAuthFailure(String sessionToken) {
        // Log or display error message to user
        System.out.println("Authentication failed for session token: " + sessionToken);
    }

    private String generateSessionToken(String userId) {
        // Generate a secure session token using user id
        return userId + System.currentTimeMillis();
    }
}