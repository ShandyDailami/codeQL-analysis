import java.util.HashMap;
import java.util.UUID;

public class java_23375_SessionManager_A03 {

    // SessionRepository interface is a placeholder for a real implementation
    private SessionRepository sessionRepository;

    // A map to store sessions
    private HashMap<UUID, String> sessionMap;

    // Constructor
    public java_23375_SessionManager_A03(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession() {
        // Generate a unique session ID
        UUID sessionId = UUID.randomUUID();

        // Store the session ID in the map
        sessionMap.put(sessionId, sessionRepository.createSession(sessionId));

        return sessionId.toString();
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Find the session ID in the map
        sessionMap.remove(UUID.fromString(sessionId));

        // Also, end the session in the session repository
        sessionRepository.endSession(UUID.fromString(sessionId));
    }

    // Method to get a session
    public String getSession(String sessionId) {
        // Return the session from the map
        return sessionMap.get(UUID.fromString(sessionId));
    }

    // A SessionRepository interface is a placeholder for a real implementation
    public interface SessionRepository {
        String createSession(UUID sessionId);
        void endSession(UUID sessionId);
    }
}