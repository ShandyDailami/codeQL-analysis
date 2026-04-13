import java.util.HashMap;
import java.util.Map;

public class java_03445_SessionManager_A08 {

    // A map to store user sessions. 
    // In a real application, we should use a proper database or a real session store.
    private static Map<String, UserSession> sessions;

    // User session class
    public static class UserSession {
        private User user;
        private long lastAccess;

        public java_03445_SessionManager_A08(User user) {
            this.user = user;
            this.lastAccess = System.currentTimeMillis();
        }

        public User getUser() {
            return user;
        }

        public void invalidate() {
            this.lastAccess = System.currentTimeMillis();
        }

        public boolean isValid() {
            long lastAccessPlusThreeHours = this.lastAccess + 3L * 60L * 60L * 1000L;
            return this.lastAccess < lastAccessPlusThreeHours;
        }
    }

    // User class
    public static class User {
        private String name;

        public java_03445_SessionManager_A08(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // Initialize sessions map.
    static {
        sessions = new HashMap<>();
    }

    // Get session for a user.
    public static UserSession getSession(String userName) {
        UserSession session = sessions.get(userName);
        if (session == null || !session.isValid()) {
            session = new UserSession(new User(userName));
            sessions.put(userName, session);
        }
        return session;
    }

    // Invalidate a session.
    public static void invalidateSession(String userName) {
        UserSession session = sessions.get(userName);
        if (session != null) {
            session.invalidate();
        }
    }
}