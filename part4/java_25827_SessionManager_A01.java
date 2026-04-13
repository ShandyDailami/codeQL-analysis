import java.util.HashMap;

public class java_25827_SessionManager_A01 {
    private static HashMap<String, Session> sessionMap = new HashMap<>();
    private static int activeSessions = 0;

    public static Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessionMap.put(sessionId, session);
            activeSessions++;
        }
        return session;
    }

    public static void removeSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session != null) {
            session.terminate();
            sessionMap.remove(sessionId);
            activeSessions--;
        }
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    private static class Session {
        private String id;
        private boolean isActive;

        public java_25827_SessionManager_A01(String id) {
            this.id = id;
            this.isActive = true;
        }

        public void terminate() {
            isActive = false;
        }

        public boolean isActive() {
            return isActive;
        }

        public String getId() {
            return id;
        }
    }
}