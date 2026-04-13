import java.util.HashMap;
import java.util.Map;

public class java_33491_SessionManager_A07 {
    // A HashMap used to store sessions.
    private Map<String, Session> sessions;

    // A Session class that contains a username and a counter.
    private class Session {
        private String username;
        private int counter;

        public java_33491_SessionManager_A07(String username) {
            this.username = username;
            this.counter = 0;
        }

        public void incrementCounter() {
            this.counter++;
        }

        public String getUsername() {
            return username;
        }

        public int getCounter() {
            return counter;
        }
    }

    public java_33491_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String username) {
        if (sessions.containsKey(username)) {
            sessions.get(username).incrementCounter();
        } else {
            sessions.put(username, new Session(username));
        }

        return sessions.get(username).getUsername() + "_" + sessions.get(username).getCounter();
    }

    // Method to get the number of times a session was used.
    public int getSessionCount(String sessionId) {
        String username = sessionId.split("_")[0];
        String counterStr = sessionId.split("_")[1];

        if (sessions.containsKey(username)) {
            Session session = sessions.get(username);

            if (session.getUsername() + "_" + session.getCounter().equals(sessionId)) {
                return Integer.parseInt(counterStr);
            }
        }

        return -1;  // Return -1 if the session ID does not exist or is not valid.
    }

    // Method to close the session.
    public void closeSession(String sessionId) {
        String username = sessionId.split("_")[0];
        String counterStr = sessionId.split("_")[1];

        if (sessions.containsKey(username)) {
            Session session = sessions.get(username);

            if (session.getUsername() + "_" + session.getCounter().equals(sessionId)) {
                sessions.remove(username);
            }
        }
    }
}