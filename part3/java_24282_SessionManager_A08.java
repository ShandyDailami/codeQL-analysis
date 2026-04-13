import java.util.HashSet;
import java.util.Set;

public class java_24282_SessionManager_A08 {

    private Set<Object> openSessions;

    public java_24282_SessionManager_A08() {
        this.openSessions = new HashSet<>();
    }

    public void openSession(Object session) {
        if (session == null || this.openSessions.contains(session)) {
            throw new IllegalArgumentException("Invalid session");
        }
        this.openSessions.add(session);
    }

    public void closeSession(Object session) {
        if (session == null || !this.openSessions.contains(session)) {
            throw new IllegalArgumentException("Invalid session");
        }
        this.openSessions.remove(session);
    }

    public Object getSession(String sessionId) {
        for (Object session : this.openSessions) {
            if (session.toString().equals(sessionId)) {
                return session;
            }
        }
        throw new IllegalArgumentException("Invalid session id");
    }

    public void integrityFailure() {
        throw new SecurityException("Integrity failure detected");
    }
}