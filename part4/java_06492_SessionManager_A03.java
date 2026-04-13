import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class java_06492_SessionManager_A03 {
    private Map<String, WeakReference<Session>> sessionMap;

    public java_06492_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, new WeakReference<>(session));
        return session;
    }

    public Session getSession(String sessionId) {
        WeakReference<Session> weakReference = sessionMap.get(sessionId);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void destroySession(String sessionId) {
        WeakReference<Session> weakReference = sessionMap.get(sessionId);
        if (weakReference == null) {
            return;
        }
        weakReference.clear();
        sessionMap.remove(sessionId);
    }

    public void clearAllSessions() {
        for (WeakReference<Session> weakReference : sessionMap.values()) {
            weakReference.clear();
        }
        sessionMap.clear();
    }
}

class Session {
    private String sessionId;

    public java_06492_SessionManager_A03(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void cleanup() {
        // This method is used for demonstration purposes and does not actually do anything in this example.
    }
}