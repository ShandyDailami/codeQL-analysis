import java.util.HashMap;
import java.util.Map;

public class java_12405_SessionManager_A03 {
    // Use thread local variable to store session data.
    private static final ThreadLocal<Map<String, Object>> sessionMap = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    // Open a session.
    public static void openSession() {
        // Open a session for a user.
        Map<String, Object> session = sessionMap.get();
        // Check if the session is already open.
        if (session.isEmpty()) {
            session.put("sessionId", System.currentTimeMillis());
        }
    }

    // Get session data.
    public static Object get(String key) {
        Map<String, Object> session = sessionMap.get();
        // Check if the session is already open.
        if (!session.isEmpty()) {
            return session.get(key);
        }
        return null;
    }

    // Set session data.
    public static void set(String key, Object value) {
        Map<String, Object> session = sessionMap.get();
        // Check if the session is already open.
        if (!session.isEmpty()) {
            session.put(key, value);
        }
    }

    // Close the session.
    public static void closeSession() {
        Map<String, Object> session = sessionMap.get();
        // Check if the session is already open.
        if (!session.isEmpty()) {
            session.clear();
        }
    }
}