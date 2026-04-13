public class java_25921_SessionManager_A08 {
    private int currentSession;
    private Session[] sessions;

    // Maximum number of sessions allowed
    private static final int MAX_SESSIONS = 10;

    public java_25921_SessionManager_A08() {
        this.sessions = new Session[MAX_SESSIONS];
        this.currentSession = 0;
    }

    public Session createSession() {
        if (this.currentSession >= MAX_SESSIONS) {
            System.out.println("Error: Maximum sessions limit reached!");
            return null;
        }

        Session session = new Session();
        this.sessions[this.currentSession] = session;
        this.currentSession++;

        return session;
    }

    public void closeSession(Session session) {
        if (session == null) {
            System.out.println("Error: Session not found!");
            return;
        }

        for (int i = 0; i < this.currentSession; i++) {
            if (this.sessions[i] == session) {
                this.sessions[i] = null;
                this.currentSession--;
                return;
            }
        }

        System.out.println("Error: Session not found!");
    }
}

public class Session {
    // Empty for the sake of the example
}