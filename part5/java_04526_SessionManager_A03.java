public class java_04526_SessionManager_A03 {
    private static int MAX_NUMBER_OF_SESSIONS = 10;
    private static int NUMBER_OF_ACTIVE_SESSIONS = 0;
    private static List<Session> activeSessions = new ArrayList<>();

    public static Session getSession() {
        if (NUMBER_OF_ACTIVE_SESSIONS < MAX_NUMBER_OF_SESSIONS) {
            Session session = new Session();
            activeSessions.add(session);
            NUMBER_OF_ACTIVE_SESSIONS++;
            return session;
        } else {
            throw new RuntimeException("No more sessions available.");
        }
    }

    public static void closeSession(Session session) {
        if (activeSessions.contains(session)) {
            activeSessions.remove(session);
            NUMBER_OF_ACTIVE_SESSIONS--;
        } else {
            throw new RuntimeException("The session does not exist.");
        }
    }

    public static class Session {
        // This is just a placeholder for the session object.
    }
}