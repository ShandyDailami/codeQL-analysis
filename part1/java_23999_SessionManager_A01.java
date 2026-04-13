import java.util.ArrayList;
import java.util.List;

public class java_23999_SessionManager_A01 {
    private List<Session> sessions = new ArrayList<>();

    public void createSession(String userId) {
        sessions.add(new Session(userId));
    }

    public Session getSession(String userId) {
        for (Session session : sessions) {
            if (session.userId.equals(userId)) {
                return session;
            }
        }
        return null;
    }

    public void closeSession(String userId) {
        sessions.removeIf(session -> session.userId.equals(userId));
    }

    public void removeAllSessions() {
        sessions.clear();
    }

    public static class Session {
        String userId;

        Session(String userId) {
            this.userId = userId;
        }

        public void doSecuritySensitiveOperation1() {
            // Implement security sensitive operation 1
            // This operation is deliberately left simple to allow for creativity.
            // For example, it can print out the userId.
            System.out.println("Security sensitive operation 1: " + userId);
        }

        public void doSecuritySensitiveOperation2() {
            // Implement security sensitive operation 2
            // This operation is deliberately left simple to allow for creativity.
            // For example, it can print out the userId.
            System.out.println("Security sensitive operation 2: " + userId);
        }
    }
}