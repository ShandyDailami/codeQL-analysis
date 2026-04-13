public class java_30144_SessionManager_A01 {

    private static final int MAX_SESSIONS = 5;
    private static int activeSessions = 0;

    public static Session createSession() {
        if (activeSessions < MAX_SESSIONS) {
            activeSessions++;
            System.out.println("Session created: " + activeSessions);
            return new Session();
        } else {
            System.out.println("Maximum sessions reached: " + activeSessions);
            return null;
        }
    }

    public static void closeSession(Session session) {
        if (session != null) {
            activeSessions--;
            System.out.println("Session closed: " + activeSessions);
        } else {
            System.out.println("No active session to close");
        }
    }

    public static class Session {
        private static int sessions = 0;

        public java_30144_SessionManager_A01() {
            sessions++;
            if (sessions > MAX_SESSIONS) {
                System.out.println("Session is not allowed: " + sessions);
            } else {
                System.out.println("Session allowed: " + sessions);
            }
        }

        public void dispose() {
            sessions--;
            if (sessions < 0) {
                System.out.println("Session disposed: " + sessions);
            } else {
                System.out.println("Session allowed: " + sessions);
            }
        }
    }

    public static void main(String[] args) {
        SessionManager.createSession();
        SessionManager.createSession();
        SessionManager.createSession();
        SessionManager.createSession();
        SessionManager.createSession();
        SessionManager.createSession();

        SessionManager.Session session1 = SessionManager.createSession();
        SessionManager.Session session2 = SessionManager.createSession();

        session1.dispose();
        session2.dispose();

        SessionManager.closeSession(session1);
        SessionManager.closeSession(session2);
    }
}