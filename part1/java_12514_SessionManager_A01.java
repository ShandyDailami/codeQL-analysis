public class java_12514_SessionManager_A01 {
    private List<Session> sessions;
    private int sessionCount;
    private static final int MAX_SESSIONS = 10;

    public java_12514_SessionManager_A01() {
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public Session createSession() {
        if (sessionCount < MAX_SESSIONS) {
            Session session = new Session();
            sessions.add(session);
            sessionCount++;
            return session;
        } else {
            System.out.println("Error: Maximum number of sessions reached");
            return null;
        }
    }

    public Session getSession(int index) {
        if (index >= 0 && index < sessionCount) {
            return sessions.get(index);
        } else {
            System.out.println("Error: Invalid session index");
            return null;
        }
    }

    public void deleteSession(int index) {
        if (index >= 0 && index < sessionCount) {
            sessions.remove(index);
            sessionCount--;
        } else {
            System.out.println("Error: Invalid session index");
        }
    }
}