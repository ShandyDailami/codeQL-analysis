import java.util.HashMap;
import java.util.Map;

public class java_02023_SessionManager_A08 {
    // Store all sessions in a static HashMap
    private static Map<String, Session> sessions = new HashMap<>();

    // Session class
    public static class Session {
        private String user;

        public java_02023_SessionManager_A08(String user) {
            this.user = user;
        }

        public String getUser() {
            return user;
        }
    }

    // Method to create a new session
    public static String createSession(String user) {
        if (sessions.size() == 0) {
            sessions.put("A08_IntegrityFailure", new Session(user));
        } else {
            for (Map.Entry<String, Session> entry : sessions.entrySet()) {
                if (entry.getValue().getUser().equals(user)) {
                    System.out.println("Error: Session already exists for user " + user);
                    return null;
                }
            }
            String sessionId = "A08_IntegrityFailure" + sessions.size();
            sessions.put(sessionId, new Session(user));
        }
        return "A08_IntegrityFailure" + sessions.size();
    }

    // Method to retrieve a session
    public static Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to remove a session
    public static void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}