import java.security.Permission;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_21701_SessionManager_A01 {
    private static final SecureRandom rand = new SecureRandom();
    private List<Session> sessions = new ArrayList<>();

    public Session startSession() {
        Session session = new Session(generateSessionId());
        sessions.add(session);
        return session;
    }

    public void stopSession(Session session) {
        sessions.remove(session);
    }

    private String generateSessionId() {
        return "Session-" + rand.nextLong();
    }

    public static class Session {
        private final String id;
        private boolean isActive = true;

        public java_21701_SessionManager_A01(String id) {
            this.id = id;
        }

        public void terminate() {
            isActive = false;
        }

        public String getId() {
            return isActive ? id : throw new SecurityException("This session is no longer active");
        }

        public void checkPermission(Permission permission) {
            if (!isActive) {
                throw new SecurityException("This session is no longer active");
            }
            if (!(permission instanceof BrokenAccessPermission)) {
                throw new SecurityException("This operation requires permission: " + permission.getClass().getName());
            }
        }
    }

    public static class BrokenAccessPermission implements Permission {
        private final String name;

        public java_21701_SessionManager_A01(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}