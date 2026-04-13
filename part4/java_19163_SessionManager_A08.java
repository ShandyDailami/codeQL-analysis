import java.util.HashMap;

public class java_19163_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private static SessionManager sessionManager;

    private java_19163_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public static SessionManager getInstance() {
        if(sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public void startSession(String sessionId, String userName) {
        if(sessionMap.containsKey(sessionId)) {
            System.out.println("A session with id " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Started session with id " + sessionId + " for user " + userName + ".");
        }
    }

    public void endSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with id " + sessionId + " for user " + userName + ".");
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }

    public void changeUserNameInSession(String sessionId, String newUserName) {
        if(sessionMap.containsKey(sessionId)) {
            String oldUserName = sessionMap.get(sessionId);
            sessionMap.put(sessionId, newUserName);
            System.out.println("Changed user name from " + oldUserName + " to " + newUserName + " in session with id " + sessionId + ".");
        } else {
            System.out.println("No session with id " + sessionId + " exists.");
        }
    }
}