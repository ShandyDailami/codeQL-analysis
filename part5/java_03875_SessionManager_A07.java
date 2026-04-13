import java.util.HashMap;
import java.util.Map;

public class java_03875_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_03875_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (validateUser(userId)) {
            sessionMap.put(sessionId, userId);
            System.out.println("Session started with ID: " + sessionId);
        } else {
            System.out.println("Authentication failed for user: " + userId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended with ID: " + sessionId + ". User ID: " + userId);
        } else {
            System.out.println("No active session with ID: " + sessionId);
        }
    }

    private boolean validateUser(String userId) {
        // Simulate authentication by checking if userId is in a valid user list.
        // In a real application, this would likely involve making a network request to a server
        // to verify the user's identity and return a boolean value.
        return isValidUser(userId);
    }

    private boolean isValidUser(String userId) {
        // This is a placeholder, in a real application, you would replace this method with a call
        // to a server or a database to check if the userId is valid.
        return userId.equals("validUser");
    }
}