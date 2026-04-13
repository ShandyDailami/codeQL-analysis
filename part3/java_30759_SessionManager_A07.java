import java.util.HashMap;
import java.util.Map;

public class java_30759_SessionManager_A07 {
    // Store the session data in a Map
    private Map<String, String> sessionData;

    // Constructor
    public java_30759_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    // Method to store session data
    public void storeSessionData(String sessionId, String data) {
        this.sessionData.put(sessionId, data);
    }

    // Method to retrieve session data
    public String retrieveSessionData(String sessionId) {
        if (sessionData.containsKey(sessionId)) {
            return sessionData.get(sessionId);
        } else {
            // Handle case where session data does not exist
            return null;
        }
    }

    // Security-sensitive operation related to authentication failure
    public void authenticateFailure(String sessionId, String failureMessage) {
        String data = this.retrieveSessionData(sessionId);

        // Check if session data represents a username and password
        if (data != null && data.contains(":")) {
            String[] credentials = data.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // Check if username and password match a predefined set
            if (username.equals("admin") && password.equals("password")) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed: " + failureMessage);
            }
        } else {
            System.out.println("Invalid session data: " + failureMessage);
        }
    }
}