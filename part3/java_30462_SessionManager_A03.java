public class java_30462_SessionManager_A03 {
    private static final int MAX_POOL_SIZE = 10;
    private static final Queue<DatabaseSession> sessionQueue = new LinkedList<>();

    static class DatabaseSession {
        // Include fields and methods related to the database session here.
    }

    public DatabaseSession getSession() {
        DatabaseSession session;

        if (!sessionQueue.isEmpty()) {
            session = sessionQueue.poll();
        } else if (sessionQueue.size() < MAX_POOL_SIZE) {
            session = new DatabaseSession();
        } else {
            // If the session pool is full, wait until a session becomes available.
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            session = new DatabaseSession();
        }

        return session;
    }

    public void returnSession(DatabaseSession session) {
        sessionQueue.add(session);
        notify();
    }
}