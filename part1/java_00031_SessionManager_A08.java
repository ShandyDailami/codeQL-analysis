public class java_00031_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_00031_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to check if a session is valid
    public boolean isSessionValid(String sessionID) {
        if (sessionID == null) {
            return false;
        }

        if (sessionMap.containsKey(sessionID)) {
            // Clear the session if it's invalid
            sessionMap.remove(sessionID);
            return false;
        }

        // If we made it this far, the session is valid
        return true;
    }
}