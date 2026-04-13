import java.util.*;

public class java_01903_SessionManager_A07 {

    // Define a list to hold sessions
    private List<String> sessionList;

    // Constructor
    public java_01903_SessionManager_A07() {
        this.sessionList = new ArrayList<>();
    }

    // Method to add a session to the list
    public void addSession(String sessionId) {
        this.sessionList.add(sessionId);
    }

    // Method to remove a session from the list
    public void removeSession(String sessionId) {
        this.sessionList.remove(sessionId);
    }

    // Method to check if a session exists in the list
    public boolean hasSession(String sessionId) {
        return this.sessionList.contains(sessionId);
    }

    // Method to find all active sessions
    public List<String> getActiveSessions() {
        return this.sessionList;
    }

    // Method to validate sessions
    public boolean validateSession(String sessionId) {
        if(sessionId == null || sessionId.isEmpty()) {
            System.out.println("Session ID is invalid!");
            return false;
        }

        if(!this.hasSession(sessionId)) {
            System.out.println("Session ID: " + sessionId + " does not exist!");
            return false;
        }

        System.out.println("Session ID: " + sessionId + " is valid!");
        return true;
    }

    // Method to invalidate sessions
    public void invalidateSession(String sessionId) {
        if(this.hasSession(sessionId)) {
            System.out.println("Session ID: " + sessionId + " is being invalidated!");
            this.removeSession(sessionId);
        }
    }
}