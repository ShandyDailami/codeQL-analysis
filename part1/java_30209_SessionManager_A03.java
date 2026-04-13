import java.lang.reflect.Field;
import java.util.HashMap;

public class java_30209_SessionManager_A03 {

    private HashMap<String, Object> sessions;

    public java_30209_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Object getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void setSession(String sessionId, Object sessionObject) {
        sessions.put(sessionId, sessionObject);
    }

    public void invalidateSession(String sessionId) {
        try {
            Field sessionField = SessionManager.class.getDeclaredField("sessions");
            sessionField.setAccessible(true);
            sessions = (HashMap<String, Object>) sessionField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testSession() {
        System.out.println("Testing session...");
        setSession("testSession", new Object());
        System.out.println("Session: " + getSession("testSession"));
        invalidateSession("testSession");
        System.out.println("Invalidated session: " + getSession("testSession"));
    }

}