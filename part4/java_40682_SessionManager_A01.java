import java.util.ArrayList;
import java.util.List;

public class java_40682_SessionManager_A01 {
    private List<Session> sessions = new ArrayList<>();

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void destroySession(Session session) {
        sessions.remove(session);
    }

    public class Session {
        private boolean isActive = false;

        public void start() {
            if (!isActive) {
                System.out.println("Session started");
                isActive = true;
            }
        }

        public void stop() {
            if (isActive) {
                System.out.println("Session stopped");
                isActive = false;
           
            }
        }

        public void close() {
            if (isActive) {
                System.out.println("Session closed");
                isActive = false;
            }
        }

        public boolean isActive() {
            return isActive;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.createSession();
        session1.start();
        session1.stop();
        session1.close();

        Session session2 = sessionManager.createSession();
        session2.start();
        session2.stop();
        session2.close();

        sessionManager.destroySession(session1);
        sessionManager.destroySession(session2);
    }
}