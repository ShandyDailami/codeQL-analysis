public class java_40566_SessionManager_A08 {
    // This is a simple in-memory representation of a SessionManager.
    // In a real-world application, this would likely be replaced with a more sophisticated data structure.
    private static Map<Long, Session> sessionMap = new HashMap<>();
    private static long sequence = 0L;

    public Session createSession() {
        long sessionId = generateSessionId();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(long sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(long sessionId) {
        sessionMap.remove(sessionId);
    }

    private long generateSessionId() {
        return ++sequence;
    }

    // Session class is not shown for brevity.
}