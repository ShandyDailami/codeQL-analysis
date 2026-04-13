import java.util.HashSet;
import java.util.Set;

public class java_30256_SessionManager_A01 {
    private Set<Session> activeSessions;
    private Set<Session> inactiveSessions;
    
    public java_30256_SessionManager_A01() {
        activeSessions = new HashSet<>();
        inactiveSessions = new HashSet<>();
    }
    
    public Session createSession() {
        Session session = new Session();
        activeSessions.add(session);
        return session;
    }
    
    public void closeSession(Session session) {
        if (activeSessions.remove(session)) {
            inactiveSessions.add(session);
        } else {
            throw new IllegalStateException("Trying to close non-existing session");
        }
    }
    
    public void cleanup() {
        for (Session session : inactiveSessions) {
            session.close(); // assuming Session class has a close method
        }
        inactiveSessions.clear();
    }
    
    private class Session {
        // Fields and methods here
    }
}