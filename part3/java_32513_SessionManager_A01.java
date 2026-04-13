import java.util.*;

public class java_32513_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_32513_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String userId) {
        Session session = new Session(userId);
        sessions.put(userId, session);
        return session;
    }

    public Session getSession(String userId) {
        Session session = sessions.get(userId);
        if (session == null) {
            throw new SecurityException("User is not authorized to access the system");
        }
        return session;
    }

    public void closeSession(String userId) {
        Session session = sessions.get(userId);
        if (session == null) {
            throw new SecurityException("User is not authorized to access the system");
        }
        sessions.remove(userId);
    }
}

class Session {
    private String userId;

    public java_32513_SessionManager_A01(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}