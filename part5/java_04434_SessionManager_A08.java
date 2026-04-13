import java.util.HashMap;

public class java_04434_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_04434_SessionManager_A08() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public String createSession(String userID, String sessionID) {
        if (!userMap.containsKey(userID)) {
            System.out.println("Error: User does not exist");
            return null;
        }
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getSessionUser(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            System.out.println("Error: Session does not exist");
            return null;
        }
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        if (!sessionMap.containsKey(sessionID)) {
            System.out.println("Error: Session does not exist");
            return;
        }
        String userID = sessionMap.get(sessionID);
        sessionMap.remove(sessionID);
        userMap.remove(userID);
    }
}