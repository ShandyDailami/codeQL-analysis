import java.security.SecureRandom;
import java.util.Base64;

public class java_25478_SessionManager_A08 {
    private static final SecureRandom random = new SecureRandom();
    private static final Base64.Encoder encoder = Base64.getUrlEncoder();

    // Simulating a database table for storing sessions
    private static class Session {
        private String id;
        private long creationTime;
        private long lastAccessed;

        public java_25478_SessionManager_A08(String id) {
            this.id = id;
            this.creationTime = System.currentTimeMillis();
            this.lastAccessed = this.creationTime;
        }

        public void updateLastAccessed() {
            this.lastAccessed = System.currentTimeMillis();
        }

        public boolean isStale() {
            return System.currentTimeMillis() - this.lastAccessed > 10000; // 10 seconds
        }
    }

    private static final Session[] sessions = new Session[10000];
    private static int sessionCount = 0;

    public static void main(String[] args) throws InterruptedException {
        // Populate the sessions table with dummy data
        for (int i = 0; i < sessions.length; i++) {
            sessions[i] = new Session("session-" + i);
        }

        while (true) {
            // Access a session
            Thread.sleep(1000);
            String id = sessions[random.nextInt(sessions.length)].id;
            Session session = getSession(id);
            if (session != null) {
                session.updateLastAccessed();
            }
       
            // Check if the session is stale and remove it if so
            for (int i = 0; i < sessions.length; i++) {
                Session s = sessions[i];
                if (s != null && s.isStale()) {
                    sessions[i] = null;
                    sessionCount--;
                    System.out.println("Session " + s.id + " is stale and has been removed.");
                }
            }
        }
    }

    private static Session getSession(String id) {
        for (int i = 0; i < sessions.length; i++) {
            if (sessions[i] != null && sessions[i].id.equals(id)) {
                return sessions[i];
            }
        }
        return null;
    }
}