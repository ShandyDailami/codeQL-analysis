public class java_13919_SessionManager_A08 {
    private static int sessionCount = 0;
    private static final int MAX_SESSIONS = 10;

    // A static array to hold the sessions
    private static Session[] sessions = new Session[MAX_SESSIONS];

    // A static array to hold the sessions with active flags
    private static boolean[] activeSessions = new boolean[MAX_SESSIONS];

    public static Session createSession() {
        if (sessionCount < MAX_SESSIONS) {
            Session session = new Session();
            sessions[sessionCount] = session;
            activeSessions[sessionCount] = true;
            sessionCount++;
            return session;
        } else {
            System.out.println("Maximum number of sessions reached!");
            return null;
        }
    }

    public static void closeSession(Session session) {
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] == session) {
                sessions[i] = null;
                activeSessions[i] = false;
                sessionCount--;
                System.out.println("Session " + i + " closed successfully!");
                return;
            }
        }
    }

    public static void main(String[] args) {
        // Create some sessions
        Session session1 = createSession();
        Session session2 = createSession();

        // Close one of the sessions
        closeSession(session1);

        // Try to close the remaining session
        closeSession(session2);
    }
}