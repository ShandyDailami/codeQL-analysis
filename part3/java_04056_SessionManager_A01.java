public class java_04056_SessionManager_A01 {
    private Map<String, UserSession> sessions;

    public java_04056_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public UserSession createSession(User user) {
        String sessionId = UUID.randomUUID().toString();
        UserSession session = new UserSession(user, sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public UserSession getSession(String sessionId) throws SessionNotFoundException {
        UserSession session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found with id: " + sessionId);
        }
        return session;
    }

    public void deleteSession(String sessionId) throws SessionNotFoundException {
        UserSession session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found with id: " + sessionId);
        }
        sessions.remove(sessionId);
    }
}