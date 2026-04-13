import java.util.HashMap;

public class java_34552_SessionManager_A03 {
    private HashMap<String, String> sessionData;

    public java_34552_SessionManager_A03() {
        sessionData = new HashMap<>();
    }

    public String createSession(String sessionID) {
        if (sessionData.containsKey(sessionID)) {
            System.out.println("Session ID already exists. Cannot create a session.");
            return null;
        }
        sessionData.put(sessionID, "Session Data");
        return sessionID;
    }

    public String getSession(String sessionID) {
        if (!sessionData.containsKey(sessionID)) {
            System.out.println("Session ID does not exist. Cannot retrieve session.");
            return null;
        }
        return sessionData.get(sessionID);
    }

    public boolean destroySession(String sessionID) {
        if (!sessionData.containsKey(sessionID)) {
            System.out.println("Session ID does not exist. Cannot destroy session.");
            return false;
        }
        sessionData.remove(sessionID);
        return true;
    }
}