import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class java_32449_SessionManager_A03 {
    // Create a map to hold sessions.
    private Map<String, Object> sessionMap;

    // Constructor
    public java_32449_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session.
    public Object createSession(String sessionId, Object sessionObject) {
        sessionMap.put(sessionId, sessionObject);
        return sessionObject;
    }

    // Method to retrieve a session.
    public Object getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to inject a session into a method.
    public void injectSessionIntoMethod(String sessionId, String methodName) {
        Object session = getSession(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session with ID: " + sessionId);
        }

        try {
            Method method = session.getClass().getMethod(methodName, new Class[]{});
            method.invoke(session, new Object[]{});
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalStateException("Cannot invoke method: " + methodName + " on session: " + sessionId, e);
        }
    }
}