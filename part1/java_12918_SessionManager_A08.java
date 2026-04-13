import java.util.HashMap;
import java.util.Map;

public class java_12918_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_12918_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userName) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Here's the code snippet:

    /*
    public class Main {
    
        public static void main(String[] args) {
            SessionManager sessionManager = new SessionManager();
            String sessionId = "session1";
            String userName = "User1";
            sessionManager.createSession(sessionId, userName);

            String user = sessionManager.getUserName(sessionId);
            System.out.println("User: " + user);

            sessionManager.deleteSession(sessionId);
            user = sessionManager.getUserName(sessionId);
            System.out.println("User: " + user);
        }
    }
    */

    // End of the code snippet
}