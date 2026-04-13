import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;

public class java_18127_SessionManager_A08 {
    // Define a weak reference to Session
    private Map<String, WeakReference<Session>> sessions;

    // Initialize the sessions map
    public java_18127_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    // Create a new session
    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), new WeakReference<>(session));
        return session;
    }

    // Retrieve a session
    public Session getSession(String id) {
        WeakReference<Session> weakReference = sessions.get(id);
        if (weakReference == null) {
            return null;
        }

        Session session = weakReference.get();
        if (session == null) {
            sessions.remove(id);
            return null;
        }

        return session;
    }

    // Session class
    public class Session {
        private String id;

        // Session constructor
        public java_18127_SessionManager_A08() {
            this.id = String.valueOf(System.currentTimeMillis());
        }

        // Session getter
        public String getId() {
            return this.id;
        }
    }
}