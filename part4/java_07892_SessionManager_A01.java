import java.util.LinkedList;

public class java_07892_SessionManager_A01 {
    private static LinkedList<Session> sessions;
    private static int currentSessionId = 0;

    static class Session {
        int sessionId;
        boolean isValid;

        Session(int sessionId) {
            this.sessionId = sessionId;
            this.isValid = true;
        }
    }

    public java_07892_SessionManager_A01() {
        sessions = new LinkedList<>();
    }

    public int createSession() {
        Session session = new Session(currentSessionId);
        sessions.add(session);
        return currentSessionId++;
    }

    public void invalidateSession(int sessionId) {
        for (Session session : sessions) {
            if (session.sessionId == sessionId) {
                session.isValid = false;
                break;
            }
        }
    }

    public boolean isValid(int sessionId) {
        for (Session session : sessions) {
            if (session.sessionId == sessionId && session.isValid) {
                return true;
            }
        }
        return false;
    }
}