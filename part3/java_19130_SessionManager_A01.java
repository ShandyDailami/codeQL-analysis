import java.util.HashMap;
import java.util.Map;

public class java_19130_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_19130_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        if(hasValidAccess(sessionId, user)) {
            sessionMap.put(sessionId, user);
        } else {
            System.out.println("Access Denied for session: " + sessionId);
        }
    }

    public String getSession(String sessionId) {
        if(hasValidAccess(sessionId, sessionMap.get(sessionId))) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("Access Denied for session: " + sessionId);
            return null;
        }
    }

    public void removeSession(String sessionId) {
        if(hasValidAccess(sessionId, sessionMap.get(sessionId))) {
            sessionMap.remove(sessionId);
        } else {
            System.out.println("Access Denied for session: " + sessionId);
        }
    }

    private boolean hasValidAccess(String sessionId, String user) {
        // Assume a login system exists for the purpose of this example.
        // This is a placeholder and should be replaced with actual login logic.
        return user != null && user.equals("Admin");
    }

}