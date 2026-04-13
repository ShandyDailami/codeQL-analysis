import java.util.HashMap;

public class java_13273_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_13273_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionID = user + System.currentTimeMillis();
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public void checkSessionIntegrity(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            throw new SecurityException("Session integrity failure: Session ID does not exist");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String sessionID = manager.createSession("user1");
        System.out.println("Created session ID: " + sessionID);
        manager.checkSessionIntegrity(sessionID);
        System.out.println("User in session: " + manager.getUserFromSession(sessionID));
        manager.deleteSession(sessionID);
        System.out.println("Session deleted: " + sessionID);
    }
}