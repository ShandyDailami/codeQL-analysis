import java.util.ArrayList;

public class java_12072_SessionManager_A03 {

    private ArrayList<String> sessions;
    private int sessionCount = 0;

    public java_12072_SessionManager_A03() {
        sessions = new ArrayList<>();
    }

    // Method to start a session
    public String startSession() {
        sessionCount++;
        String sessionID = "session_" + sessionCount;
        sessions.add(sessionID);
        return sessionID;
    }

    // Method to end a session
    public boolean endSession(String sessionID) {
        if(sessions.contains(sessionID)) {
            sessions.remove(sessionID);
            return true;
        } else {
            return false;
        }
    }

    // Method to check if a session is active
    public boolean isActiveSession(String sessionID) {
        return sessions.contains(sessionID);
    }

    // Method to get the count of active sessions
    public int getActiveSessionCount() {
        return sessions.size();
    }

    // For academic purposes, these methods are empty. You could use them for real-world applications.
    public ArrayList<String> getAllSessions() {
        return sessions;
    }

    public int getSessionCount() {
        return sessionCount;
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String session1 = sm.startSession();
        String session2 = sm.startSession();
        sm.endSession(session1);
        System.out.println("Active session count: " + sm.getActiveSessionCount());
        System.out.println("Session " + session2 + " is active: " + sm.isActiveSession(session2));
    }
}