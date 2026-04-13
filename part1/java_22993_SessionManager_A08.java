public class java_22993_SessionManager_A08 {
    private static Session[] sessions = new Session[100];
    private static int sessionCount = 0;

    public static void startSession(User user) {
        if (sessionCount >= sessions.length) {
            throw new RuntimeException("No more sessions can be started");
        }
        Session session = new Session();
        session.user = user;
        sessions[sessionCount++] = session;
    }

    public static void endSession(Session session) {
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] == session) {
                sessions[i] = null;
                sessionCount--;
                return;
            }
        }
        throw new RuntimeException("This session was not started by this manager");
    }

    public static User getLoggedInUser() {
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i] != null) {
                return sessions[i].user;
            }
        }
        throw new RuntimeException("No user is currently logged in");
    }
}

class Session {
    User user;
}

class User {
    // User data
}