import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class java_03563_SessionManager_A01 {

    private final ConcurrentHashMap<String, Session> sessions;

    public java_03563_SessionManager_A01() {
        this.sessions = new ConcurrentHashMap<>();
    }

    public Session startSession(String userName) {
        return sessions.computeIfAbsent(userName, s -> new Session(s));
    }

    public void endSession(String userName) {
        sessions.remove(userName);
    }

    public Session getSession(String userName) {
        return sessions.get(userName);
    }

    public static class Session {

        private final String userName;

        public java_03563_SessionManager_A01(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void invalidate() {
            // Implementation of invalidation method
        }
    }

    public static class SessionManagerFactory {

        private static final SessionManagerFactory INSTANCE = new SessionManagerFactory();

        private java_03563_SessionManager_A01() {
        }

        public static SessionManagerFactory getInstance() {
            return INSTANCE;
        }

        public VanillaSessionManager createSessionManager() {
            return new VanillaSessionManager();
        }
    }
}