public class java_10210_SessionManager_A01 {
    // A map to hold sessions
    private Map<String, Session> sessions = new HashMap<>();

    // A map to hold session IDs
    private Map<String, String> sessionIDs = new HashMap<>();

    // A map to hold session keys
    private Map<String, String> sessionKeys = new HashMap<>();

    // A map to hold session values
    private Map<String, String> sessionValues = new HashMap<>();

    // The current session ID
    private String currentSessionID = "";

    // Method to create a new session
    public String createSession() {
        // Generate a new session ID
        String sessionID = UUID.randomUUID().toString();

        // Store the session ID in the map
        sessionIDs.put(sessionID, sessionID);

        // Store the session ID in the map
        sessions.put(sessionID, new Session());

        // Return the session ID
        return sessionID;
    }

    // Method to close an existing session
    public void closeSession(String sessionID) {
        // If the session ID is in the map
        if (sessions.containsKey(sessionID)) {
            // Remove the session from the map
            sessions.remove(sessionID);

            // Remove the session ID from the map
            sessionIDs.remove(sessionID);
        }
    }

    // Method to set a value in a session
    public void setValue(String sessionID, String key, String value) {
        // If the session ID is in the map
        if (sessions.containsKey(sessionID)) {
            // Set the value in the session
            sessions.get(sessionID).setValue(key, value);
        }
    }

    // Method to get a value from a session
    public String getValue(String sessionID, String key) {
        // If the session ID is in the map
        if (sessions.containsKey(sessionID)) {
            // Get the value from the session
            return sessions.get(sessionID).getValue(key);
        }

        // Return null
        return null;
    }
}