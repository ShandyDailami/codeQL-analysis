import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class java_34091_SessionManager_A03 {

    private List<Session> sessions = new ArrayList<>();

    public java_34091_SessionManager_A03() {
        System.out.println("SessionManager created.");
    }

    public Session createSession(Subject subject) {
        Session session = new Session(subject);
        sessions.add(session);
        return session;
    }

    public void closeAllSessions() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
        System.out.println("All sessions closed.");
    }

    public static class Session {

        private Subject subject;
        private boolean isActive;

        public java_34091_SessionManager_A03(Subject subject) {
            this.subject = subject;
            this.isActive = true;
            System.out.println("Session created for user: " + subject.getPrincipal().getName());
        }

        public void close() {
            if (isActive) {
                isActive = false;
                System.out.println("Session closed for user: " + subject.getPrincipal().getName());
            }
        }
    }
}