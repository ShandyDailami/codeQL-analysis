import java.util.HashMap;

public class java_23974_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_23974_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = generateSessionID();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public boolean verifyIntegrity(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    private String generateSessionID() {
        // Assuming sessionID is a random 6-digit string
        return String.valueOf((int) (Math.random() * 900000));
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String userID = manager.createSession("User1");
        System.out.println("UserID: " + userID);
        String user = manager.getUserID(userID);
        System.out.println("User: " + user);
        boolean integrity = manager.verifyIntegrity(userID);
        System.out.println("Integrity: " + integrity);
    }
}