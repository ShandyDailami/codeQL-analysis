import java.util.LinkedList;
import java.util.Queue;

public class java_04411_SessionManager_A01 {
    private Queue<Session> sessionQueue;
    private int maxSessions;

    public java_04411_SessionManager_A01(int maxSessions) {
        this.maxSessions = maxSessions;
        this.sessionQueue = new LinkedList<>();
    }

    public Session createSession() {
        if (sessionQueue.size() >= maxSessions) {
            // Handle scenario where we've reached our max sessions.
            // This is not a real-world scenario, but this example is intended to keep it simple.
            System.out.println("Maximum sessions reached. Session creation has been prevented.");
            return null;
        }

        Session session = new Session();
        sessionQueue.add(session);

        return session;
    }

    public Session getSession() {
        if (sessionQueue.isEmpty()) {
            System.out.println("No sessions available.");
            return null;
        }

        return sessionQueue.poll();
    }

    public void closeSession(Session session) {
        // This example does not actually close the session; it's up to the Session class to do that.
        sessionQueue.remove(session);
    }
}