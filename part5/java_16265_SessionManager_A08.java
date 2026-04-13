import java.util.HashMap;
import java.util.UUID;

public class java_16265_SessionManager_A08 {
    private HashMap<UUID, Session> sessionMap;

    public java_16265_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session getSession(UUID userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            Session newSession = new Session(userId);
            sessionMap.put(userId, newSession);
            return newSession;
        }
    }

    public void closeSession(UUID userId) {
        sessionMap.remove(userId);
    }

    public class Session {
        private UUID userId;

        public java_16265_SessionManager_A08(UUID userId) {
            this.userId = userId;
        }

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }
    }
}