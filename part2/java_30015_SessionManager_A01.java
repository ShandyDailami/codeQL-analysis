public class java_30015_SessionManager_A01 {

    // An array that will store the sessions
    private Session[] sessions = new Session[5];

    // The number of sessions
    private int sessionCount = 0;

    // A class that represents a session
    public static class Session {
        // A boolean flag to indicate if the session is active
        private boolean active = false;

        // A method to start a session
        public void start() {
            active = true;
        }

        // A method to end a session
        public void end() {
            active = false;
        }

        // A method to check if a session is active
        public boolean isActive() {
            return active;
        }
    }

    // A method to create a new session
    public Session createSession() {
        Session session = new Session();
        sessions[sessionCount++] = session;
        return session;
    }

    // A method to close a session
    public void closeSession(Session session) {
        // A simple check to ensure the session is active
        if (session.isActive()) {
            session.end();
        }
    }

    // A method to close all sessions
    public void closeAllSessions() {
        // A simple loop to close all sessions
        for (int i = 0; i < sessionCount; i++) {
            sessions[i].end();
        }
    }
}