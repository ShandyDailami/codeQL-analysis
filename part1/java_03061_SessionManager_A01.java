public class java_03061_SessionManager_A01 {
    // Class to manage session objects

    // Define an array to hold session objects
    private Session[] sessions;
    private int currentIndex;

    public java_03061_SessionManager_A01(int size) {
        // Initialize sessions array with the specified size
        sessions = new Session[size];
        currentIndex = 0;
    }

    public void createSession(String sessionId) {
        // Create a new session object with the given session ID and add it to the array
        sessions[currentIndex] = new Session(sessionId);
        currentIndex++;
    }

    public Session getSession(String sessionId) {
        // Search for a session object with the given session ID in the array
        for (Session session : sessions) {
            if (session.getId().equals(sessionId)) {
                return session;
            }
        }
        // If no session object is found, return null
        return null;
    }

    public boolean destroySession(String sessionId) {
        // Find the session object to destroy in the array
        for (int i = 0; i < currentIndex; i++) {
            if (sessions[i].getId().equals(sessionId)) {
                // If the session object is found, destroy it
                sessions[i] = null;
                return true;
            }
        }
        // If no session object is found, return false
        return false;
    }

    public class Session {
        // Class to represent a session object

        private String id;

        public java_03061_SessionManager_A01(String id) {
            // Initialize session object with the given ID
            this.id = id;
        }

        public String getId() {
            // Return the session ID
            return id;
        }
    }
}