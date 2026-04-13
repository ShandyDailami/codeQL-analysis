public class java_33635_SessionManager_A07 {
    private List<Session> sessions;

    public java_33635_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.add(session);
        return session;
    }

    public void closeSession(Session session) {
        sessions.remove(session);
    }
}

public class Session {
    private int id;
    // other session fields...

    public void doSomething() {
        // do something...
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        Session session = sessionManager.createSession();
        session.doSomething();
        sessionManager.closeSession(session);
    }
}