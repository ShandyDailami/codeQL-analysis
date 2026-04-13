public class java_01333_SessionManager_A03 {
    // A map to hold our sessions. This is the real-life equivalent of a database
    private Map<String, Session> sessions;

    public java_01333_SessionManager_A03() {
        // Initialize the sessions map. In a real-life situation, this will be filled with data from a database
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Check if the session ID is already in use. In a real-life situation, we would also check if the ID is in our allowed list
        if(sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session ID already in use: " + sessionId);
        }

        // Create a new Session object and add it to the map
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to retrieve a session
    public Session getSession(String sessionId) {
        // Check if the session ID is in our map
        if(!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session found with ID: " + sessionId);
        }

        // Return the session from the map
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {
        private String id;

        public java_01333_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        // Just a basic method for demonstration
        public String getSomeData() {
            // A very simple data access method, in a real-life situation, this would be much more complex
            return "This is some data for the session: " + this.id;
        }
    }
}