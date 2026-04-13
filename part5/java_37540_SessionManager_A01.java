import java.util.HashMap;

public class java_37540_SessionManager_A01 {
    // Create a map to store sessions
    private static HashMap<String, Session> sessionMap = new HashMap<>();

    // Create a ThreadLocal to store sessions for each thread
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();

    // Start a session
    public static Session startSession(String sessionId) {
        // If a session with the given id already exists, return it
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }

        // Otherwise, create a new session and store it in the map
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Get the current session
    public static Session getCurrentSession() {
        // If no session is currently stored in the thread local, start a new session
        if (sessionThreadLocal.get() == null) {
            String sessionId = String.valueOf(System.currentTimeMillis());
            sessionThreadLocal.set(startSession(sessionId));
        }

        return sessionThreadLocal.get();
    }

    // End the current session
    public static void endSession() {
        Session session = getCurrentSession();
        session.endSession();

        // If this was the last session in the thread local, remove it
        if (session == sessionThreadLocal.get()) {
            sessionThreadLocal.set(null);
        }
    }

    // Session class
    public static class Session {
        private String sessionId;
        private boolean isActive = true;

        public java_37540_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public void endSession() {
            isActive = false;
        }

        public String getSessionId() {
            return sessionId;
        }

        public boolean isActive() {
            return isActive;
        }
    }
}