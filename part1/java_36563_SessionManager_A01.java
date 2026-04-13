import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class java_36563_SessionManager_A01 {

    private Map<String, Object> sessionMap;

    public java_36563_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionObj) {
        sessionMap.put(sessionId, sessionObj);
    }

    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) throws Exception {
        SessionManager sm = new SessionManager();
        sm.createSession("session1", new Object());

        // Use reflection to get the session object
        Field sessionField = sm.getClass().getDeclaredField("sessionMap");
        sessionField.setAccessible(true);
        Map<String, Object> sessionMap = (Map<String, Object>) sessionField.get(sm);

        // Retrieve the session object
        Object sessionObj = sessionMap.get("session1");
        System.out.println("Retrieved session object: " + sessionObj);

        sm.closeSession("session1");
    }
}