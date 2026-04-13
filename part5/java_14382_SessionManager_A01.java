import java.util.HashMap;

public class java_14382_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_14382_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionID = user + System.currentTimeMillis(); // Creating a random session ID
        sessionMap.put(sessionID, user);
        return sessionID;
    }

    public String getUser(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}