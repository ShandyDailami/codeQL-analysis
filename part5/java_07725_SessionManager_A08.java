import java.util.HashMap;
import java.util.Map;

public class java_07725_SessionManager_A08 {
    private Map<String, Session> sessions;
    private int counter;

    public java_07725_SessionManager_A08() {
        sessions = new HashMap<>();
        counter = 0;
    }

    public Session getSession(String username) {
        if (!sessions.containsKey(username)) {
            sessions.put(username, new Session(username));
        }
        Session session = sessions.get(username);
        session.incrementCounter();
        if (session.getCounter() > 5) {
            System.out.println("Integrity failure detected for session: " + username);
            // Mark the session as invalid
            sessions.remove(username);
            session = null;
        }
        return session;
    }

    public void invalidateSession(String username) {
        Session session = sessions.get(username);
        if (session != null) {
            sessions.remove(username);
            session = null;
        }
    }

    public static class Session {
        private String username;
        private int counter;

        public java_07725_SessionManager_A08(String username) {
            this.username = username;
            this.counter = 0;
        }

        public void incrementCounter() {
            counter++;
        }

        public int getCounter() {
            return counter;
        }

        public String getUsername() {
            return username;
        }
    }
}