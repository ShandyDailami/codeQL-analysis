public class java_03194_SessionManager_A08 {
    private int sessionCount = 0;

    public Session openSession() {
        sessionCount++;
        System.out.println("Opened session #" + sessionCount);
        return new Session();
    }

    public void closeSession(Session session) {
        sessionCount--;
        System.out.println("Closed session #" + sessionCount);
    }
}

public class Session {
    private static int currentSessionId = 0;
    private int sessionId;

    public java_03194_SessionManager_A08() {
        this.sessionId = ++currentSessionId;
    }

    public int getSessionId() {
        return sessionId;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session1 = sessionManager.openSession();
        Session session2 = sessionManager.openSession();
        Session session3 = sessionManager.openSession();

        sessionManager.closeSession(session1);
        sessionManager.closeSession(session2);

        // Trying to close the last session which should fail as there are no more sessions
        sessionManager.closeSession(session3);
    }
}