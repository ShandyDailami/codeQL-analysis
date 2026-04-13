import java.util.ArrayList;
import java.util.List;

public class java_30794_SessionManager_A03 implements SessionManager {
    private List<Session> sessions;

    public java_30794_SessionManager_A03() {
        sessions = new ArrayList<>();
    }

    @Override
    public Session startSession() {
        Session session = new LegacySession();
        sessions.add(session);
        return session;
    }

    @Override
    public void stopSession(Session session) {
        sessions.remove(session);
    }

    // Custom Session implementation
    private class LegacySession implements Session {
        private boolean active;

        @Override
        public void open() {
            active = true;
        }

        @Override
        public void close() {
            active = false;
        }

        @Override
        public boolean isActive() {
            return active;
        }
    }
}