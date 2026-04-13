import java.util.Map;
import java.util.HashMap;

public class java_15341_SessionManager_A07 {

    private static Map<String, Session> sessionMap = new HashMap<>();

    public static Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            session = new Session();
            sessionMap.put(sessionId, session);
        }
        return session;
    }

    public static void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private static class Session {
        private boolean isValid = true;

        public boolean isValid() {
            return isValid;
        }

        public void invalidate() {
            isValid = false;
        }
    }

    public static void main(String[] args) {
        Session session1 = getSession("session1");
        Session session2 = getSession("session2");
        Session session3 = getSession("session3");

        session2.invalidate();

        System.out.println("Session 1 is valid? " + session1.isValid());
        System.out.println("Session 2 is valid? " + session2.isValid());
        System.out.println("Session 3 is valid? " + session3.isValid());
    }
}