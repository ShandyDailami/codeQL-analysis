import java.security.AccessControl;
import java.security.AccessControlContext;
import java.security.GuardedBy;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

public class java_34103_SessionManager_A01 {
    // Define the access control strategy
    private static final AccessControlContext context =
            new AccessControlContext();
    private static final AccessControl accessControl =
            context.getAccess("modifySession");

    @GuardedBy("this.sessions")
    private Map<String, Session> sessions = new HashMap<>();

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void modifySession(String sessionId, Session newSession) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            // Use the access control strategy to ensure that the session is
            // not modified while it's being used.
            accessControl.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    session.setSessionDetails(newSession.getSessionDetails());
                    return null;
                }
            });
        }
    }
}