public class java_20820_SessionManager_A01 {

    // Static array to hold active sessions
    private static Session[] activeSessions = new Session[10];

    // Number of active sessions
    private static int activeSessionsCount = 0;

    // Session ID counter
    private static int sessionIdCounter = 0;

    // Private constructor to prevent instantiation
    private java_20820_SessionManager_A01() {
    }

    // Public method to start a session
    public static Session startSession() {
        if (activeSessionsCount == activeSessions.length) {
            System.out.println("Error: Session limit reached!");
            return null;
        }

        Session session = new Session();
        session.id = sessionIdCounter++;
        activeSessions[activeSessionsCount++] = session;

        System.out.println("Starting session " + session.id);

        return session;
    }

    // Public method to end a session
    public static void endSession(Session session) {
        int index = -1;
        for (int i = 0; i < activeSessionsCount; i++) {
            if (activeSessions[i].id == session.id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Error: Session not found!");
            return;
        }

        activeSessions[index] = activeSessions[--activeSessionsCount];

        System.out.println("Ending session " + session.id);
    }

    // Session class
    public static class Session {
        public int id;
    }
}