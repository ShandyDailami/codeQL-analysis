import java.util.LinkedList;
import java.util.Queue;

public class java_05808_SessionManager_A01 {

    private Queue<Session> sessionQueue;
    private int MAX_SIZE;

    public java_05808_SessionManager_A01(int size) {
        this.sessionQueue = new LinkedList<>();
        this.MAX_SIZE = size;
    }

    public Session createSession() {
        if(sessionQueue.size() == MAX_SIZE) {
            System.out.println("Error: Session queue is full");
            return null;
        }
        Session session = new Session();
        sessionQueue.add(session);
        return session;
    }

    public Session getSession() {
        if(sessionQueue.isEmpty()) {
            System.out.println("Error: Session queue is empty");
            return null;
        }
        return sessionQueue.poll();
    }

    public boolean closeSession(Session session) {
        return sessionQueue.remove(session);
    }

    public static class Session {
        // Simulate session data
        public void doSomething() {
            // No access control here
        }
    }

}