public class java_01871_SessionManager_A01 {
    // We'll use an array to simulate a database.
    private Session[] sessions;
    private int currentSessionIndex = 0;

    public java_01871_SessionManager_A01(int numSessions) {
        sessions = new Session[numSessions];
        for (int i = 0; i < numSessions; i++) {
            sessions[i] = new Session(i);
        }
    }

    public Session getSession() {
        // Simulate checking access control for each session.
        if (sessions[currentSessionIndex].isBroken()) {
            System.out.println("Session " + currentSessionIndex + " is broken.");
            // If the session is broken, we'll simulate an attempt to break it.
            sessions[currentSessionIndex].breakSession();
        }
        // Simulate that we're moving to the next session.
        currentSessionIndex = (currentSessionIndex + 1) % sessions.length;
        return sessions[currentSessionIndex];
    }

    public void releaseSession(Session session) {
        // We don't actually release sessions here, as we're only simulating a scenario.
        // The session manager simulates access control by releasing sessions when we're done with them.
        // In a real scenario, the session manager would release sessions when we're done with them.
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager(10);

        // Simulate doing something with 10 sessions.
        for (int i = 0; i < 10; i++) {
            Session session = sessionManager.getSession();
            System.out.println("Using session " + session.getId());
            sessionManager.releaseSession(session);
        }
    }
}

class Session {
    private int id;
    private boolean broken = false;

    public java_01871_SessionManager_A01(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isBroken() {
        return broken;
    }

    public void breakSession() {
        broken = true;
    }
}