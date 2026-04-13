import java.util.HashMap;
import java.util.UUID;

public class java_29209_SessionManager_A03 {
    // Map to store sessions.
    private HashMap<UUID, String> sessions;

    // Constructor.
    public java_29209_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public UUID createSession() {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, uuid.toString());
        return uuid;
    }

    // Method to get the session.
    public String getSession(UUID uuid) {
        return sessions.get(uuid);
    }

    // Method to delete the session.
    public void deleteSession(UUID uuid) {
        sessions.remove(uuid);
    }
}