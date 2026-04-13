import java.util.HashMap;
import java.util.Map;

public class java_25750_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_25750_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isSessionValid(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        String userID = "user1";
        String sessionID = securityManager.createSession(userID);
        System.out.println("Created session: " + sessionID);

        if (securityManager.isSessionValid(sessionID)) {
            String user = securityManager.getUserID(sessionID);
            System.out.println("User authenticated: " + user);
        } else {
            System.out.println("Session is invalid");
        }

        securityManager.endSession(sessionID);
    }
}