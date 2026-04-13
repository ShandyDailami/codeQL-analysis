import java.util.HashMap;
import java.util.Map;

public class java_33002_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_33002_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessions.containsKey(username)) {
            System.out.println("Error: Session already started for user " + username);
            return;
        }

        String sessionID = generateSessionID(username);
        sessions.put(sessionID, username);
        System.out.println("Session started for user " + username + " with ID " + sessionID);
    }

    public void endSession(String sessionID) {
        String username = sessions.get(sessionID);
        if (username == null) {
            System.out.println("Error: No session found with ID " + sessionID);
            return;
        }

        sessions.remove(sessionID);
        System.out.println("Session ended for user " + username + " with ID " + sessionID);
    }

    public String getUsername(String sessionID) {
        return sessions.get(sessionID);
    }

    private String generateSessionID(String username) {
        // You could use a hash function or some other method to generate a unique ID
        // This is just a simple example, the real implementation will depend on your specific requirements
        int hash = 0;
        for (char c : username.toCharArray()) {
            hash += c;
        }

        return String.valueOf(hash);
    }
}