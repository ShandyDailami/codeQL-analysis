import java.util.ArrayList;
import java.util.List;

public class java_31540_SessionManager_A08 {
    private List<Session> sessions = new ArrayList<>();

    public void createSession(String userId) {
        sessions.add(new Session(userId));
    }

    public Session getSession(String userId) {
        for (Session session : sessions) {
            if (session.getUserId().equals(userId)) {
                return session;
            }
        }
        return null;
    }

    public void closeSession(String userId) {
        sessions.removeIf(session -> session.getUserId().equals(userId));
    }

    public void commit() {
        System.out.println("Committing...");
    }

    public void rollback() {
        System.out.println("Rolling back...");
    }

    public void sessionFailure() {
        System.out.println("Session failed. Reason: Integrity failure.");
    }

    public static class Session {
        private String userId;

        public java_31540_SessionManager_A08(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}