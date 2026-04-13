import java.util.HashMap;

public class java_05494_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_05494_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessions.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessions.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessions.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String userID = "User1";
        String sessionID = manager.createSession(userID);
        System.out.println("Session ID: " + sessionID);

        String userID2 = "User2";
        String sessionID2 = manager.createSession(userID2);
        System.out.println("Session ID: " + sessionID2);

        System.out.println("User ID of Session ID: " + sessionID + " is: " + manager.getUserID(sessionID));
        System.out.println("User ID of Session ID: " + sessionID2 + " is: " + manager.getUserID(sessionID2));

        manager.deleteSession(sessionID2);
        System.out.println("Session ID: " + sessionID2 + " has been deleted.");
    }
}