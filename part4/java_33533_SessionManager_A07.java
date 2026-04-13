import java.util.HashMap;

public class java_33533_SessionManager_A07 {
    // Create a HashMap to store session data
    private HashMap<String, String> sessionData = new HashMap<>();

    // Add a session
    public void addSession(String sessionID, String data) {
        sessionData.put(sessionID, data);
    }

    // Retrieve session data
    public String getSessionData(String sessionID) {
        return sessionData.get(sessionID);
    }

    // Remove a session
    public void removeSession(String sessionID) {
        sessionData.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        // Add a session
        sm.addSession("session1", "Data 1");

        // Retrieve session data
        System.out.println("Session data: " + sm.getSessionData("session1"));

        // Remove a session
        sm.removeSession("session1");
    }
}