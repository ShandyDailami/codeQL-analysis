import java.util.HashMap;
import java.util.Map;

public class java_05383_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_05383_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "started");
    }

    public void endSession(String username) {
        sessionMap.put(username, "ended");
    }

    public String getSessionStatus(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            return "No session found for user " + username;
        }
    }

    public void checkForIntegrity(String username) {
        String status = getSessionStatus(username);
        if (status.equals("started")) {
            System.out.println("Error: User " + username + " has an integrity failure in the session.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Start a session
        sessionManager.startSession("alice");
        sessionManager.startSession("bob");

        // End a session
        sessionManager.endSession("alice");

        // Check the session status
        System.out.println(sessionManager.getSessionStatus("alice"));  // Should print "started"
        System.out.println(sessionManager.getSessionStatus("bob"));   // Should print "ended"

        // Check for integrity failure
        sessionManager.checkForIntegrity("alice");  // Should print an error message
    }
}