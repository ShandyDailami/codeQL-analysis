import java.util.UUID;

public class java_21226_SessionManager_A08 {

    // A session is represented by a UUID
    private UUID sessionId;

    // Constructor
    public java_21226_SessionManager_A08() {
        // Generate a new session ID
        this.sessionId = UUID.randomUUID();
    }

    // Getter for session ID
    public UUID getSessionId() {
        return this.sessionId;
    }

    public static void main(String[] args) {

        // Create a session manager
        SessionManager sessionManager = new SessionManager();

        // Print the session ID
        System.out.println("Created session with ID: " + sessionManager.getSessionId());
    }
}