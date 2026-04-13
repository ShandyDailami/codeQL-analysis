import java.util.HashSet;
import java.util.Set;

public class java_30344_SessionManager_A03 {
    private Set<Session> sessions;

    public java_30344_SessionManager_A03() {
        sessions = new HashSet<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }

    public static class Session {
        private byte[] data;

        public java_30344_SessionManager_A03(byte[] data) {
            this.data = data;
        }

        public java_30344_SessionManager_A03() {
            // No-op
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            // This is a security feature: reading data from a session is only allowed if the user has a specific role
            if (data == null || "admin".equals(new String(data))) {
                this.data = data;
            } else {
                throw new SecurityException("Reading data from session is not allowed");
            }
        }
    }
}