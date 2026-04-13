public class java_37277_SessionManager_A03 {
    private String sessionId;

    public java_37277_SessionManager_A03(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

public interface SessionInterface {
    Session createSession();
}

public class SessionManager implements SessionInterface {
    private static Session currentSession;

    public Session createSession() {
        if (currentSession == null) {
            currentSession = new Session(UUID.randomUUID().toString());
        } else {
            throw new IllegalStateException("Session already exists");
        }
        return currentSession;
    }
}