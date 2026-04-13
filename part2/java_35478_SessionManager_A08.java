import java.util.HashMap;
import java.util.Map;

public class java_35478_SessionManager_A08 {
    private Map<String, Object> sessionMap;

    public java_35478_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }

        sessionMap.put(sessionId, new SessionData());
    }

    public void updateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }

        sessionMap.get(sessionId).update();
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }

    private class SessionData {
        private String data;

        public java_35478_SessionManager_A08() {
            this.data = "Default Session Data";
        }

        public void update() {
            this.data += " - Updated";
        }

        public String getData() {
            return data;
        }
    }
}