public class java_22462_SessionManager_A07 {
    private String userName;
    private String sessionId;

    public java_22462_SessionManager_A07(String userName, String sessionId) {
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getSessionId() {
        return sessionId;
    }
}

public class SessionManager {
    private List<UserSession> sessions = new ArrayList<>();

    public String createSession(String userName) {
        String sessionId = UUID.randomUUID().toString();
        sessions.add(new UserSession(userName, sessionId));
        return sessionId;
    }

    public UserSession getSession(String sessionId) {
        for (UserSession session : sessions) {
            if (session.getSessionId().equals(sessionId)) {
                return session;
            }
        }
        return null;
    }

    public void destroySession(String sessionId) {
        sessions.removeIf(session -> session.getSessionId().equals(sessionId));
    }
}