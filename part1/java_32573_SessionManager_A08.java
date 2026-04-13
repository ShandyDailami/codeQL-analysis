import java.util.HashMap;
import java.util.UUID;

public class java_32573_SessionManager_A08 {
    private HashMap<UUID, Session> sessions;

    public java_32573_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public UUID createSession() {
        UUID uuid = UUID.randomUUID();
        sessions.put(uuid, new Session(uuid));
        return uuid;
    }

    public Session getSession(UUID uuid) {
        return sessions.get(uuid);
    }

    public void deleteSession(UUID uuid) {
        sessions.remove(uuid);
    }

    public class Session {
        private UUID uuid;

        public java_32573_SessionManager_A08(UUID uuid) {
            this.uuid = uuid;
        }

        // Add methods for your session here, for example:
        public void setData(String key, String value) {
            // Your implementation here
        }

        public String getData(String key) {
            // Your implementation here
            return null;
        }
    }
}