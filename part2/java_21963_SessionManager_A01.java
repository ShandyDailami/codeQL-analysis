import java.util.HashMap;

public class java_21963_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_21963_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // The next available session ID is the size of the HashMap
        String sessionID = String.valueOf(sessions.size());
        sessions.put(sessionID, username);
        System.out.println("Session started for user " + username + " with ID " + sessionID);
    }

    public String getUserBySessionID(String sessionID) {
        return sessions.get(sessionID);
    }

    public void endSession(String sessionID) {
        String username = sessions.get(sessionID);
        if (username != null) {
            sessions.remove(sessionID);
            System.out.println("Session ended for user " + username + " with ID " + sessionID);
        } else {
            System.out.println("No session found with ID " + sessionID);
        }
    }

    public boolean isSessionActive(String sessionID) {
        return sessions.containsKey(sessionID);
    }
}