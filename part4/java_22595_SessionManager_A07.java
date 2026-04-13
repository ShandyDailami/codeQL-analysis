import java.util.HashMap;

public class java_22595_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_22595_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String username) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists for ID: " + sessionId);
        } else {
            sessionMap.put(sessionId, username);
            System.out.println("Session started for user: " + username + " with ID: " + sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username + " with ID: " + sessionId);
        } else {
            System.out.println("No active session found for ID: " + sessionId);
        }
    }

    public void authenticate(String sessionId, String password) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("No active session found for ID: " + sessionId);
        } else {
            String username = sessionMap.get(sessionId);
            if (username.equals("admin") && password.equals("password")) {
                System.out.println("Authentication successful for user: " + username);
            } else {
                System.out.println("Authentication failed for user: " + username);
            }
        }
    }
}