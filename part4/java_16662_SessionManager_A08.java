import java.util.HashMap;

public class java_16662_SessionManager_A08 {

    private HashMap<String, String> sessionMap;

    public java_16662_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionID) {
        sessionMap.put(sessionID, sessionID);
        return sessionID;
    }

    public String getSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public boolean invalidateSession(String sessionID) {
        return sessionMap.remove(sessionID) != null;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String session1 = manager.createSession("session1");
        String session2 = manager.createSession("session2");

        System.out.println(manager.getSession("session1")); // should print session1
        System.out.println(manager.getSession("session2")); // should print session2

        manager.invalidateSession("session1");

        System.out.println(manager.getSession("session1")); // should print null
    }
}