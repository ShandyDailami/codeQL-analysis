import java.util.HashMap;

public class java_24184_SessionManager_A01 {

    private static HashMap<Long, Session> sessionMap = new HashMap<>();
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    
    public static void startSession(Long userId) {
        Session session = new Session(userId);
        sessionMap.put(userId, session);
        sessionThreadLocal.set(session);
    }

    public static Session getSession(Long userId) {
        return sessionMap.get(userId);
    }

    public static void endSession(Long userId) {
        Session existingSession = sessionMap.get(userId);
        if (existingSession == null) {
            throw new IllegalStateException("Session not found for user: " + userId);
        }
        sessionMap.remove(userId);
        sessionThreadLocal.set(null);
    }

    public static Session getCurrentSession() {
        return sessionThreadLocal.get();
    }

    public static class Session {
        private Long userId;

        public java_24184_SessionManager_A01(Long userId) {
            this.userId = userId;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "Session [userId=" + userId + "]";
        }
    }
}