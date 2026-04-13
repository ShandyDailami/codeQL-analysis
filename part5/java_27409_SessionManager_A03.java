import java.util.HashMap;
import java.util.Map;

public class java_27409_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_27409_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session not found: " + sessionId);
        }
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;
        private boolean readPermission;
        private boolean writePermission;

        public java_27409_SessionManager_A03(String id) {
            this.id = id;
            this.readPermission = false;
            this.writePermission = false;
        }

        public void setReadPermission(boolean permission) {
            this.readPermission = permission;
        }

        public void setWritePermission(boolean permission) {
            this.writePermission = permission;
        }

        public void checkPermission(String operation) {
            if (operation.equals("read") && !readPermission) {
                throw new SecurityException("Permission denied for read operation on session: " + id);
            }
            if (operation.equals("write") && !writePermission) {
                throw new SecurityException("Permission denied for write operation on session: " + id);
            }
        }
    }
}