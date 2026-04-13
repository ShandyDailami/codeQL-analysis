import java.util.HashMap;
import java.util.UUID;

public class java_34474_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_34474_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public UUID startSession(String user) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session
    public String getUserFromSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to end a session
    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Start a session
        UUID sessionId = sm.startSession("Alice");
        System.out.println("Started session with ID: " + sessionId);

        // Get the user from the session
        String user = sm.getUserFromSession(sessionId);
        System.out.println("User from session: " + user);

        // End the session
        sm.endSession(sessionId);
        System.out.println("Ended session with ID: " + sessionId);
    }
}