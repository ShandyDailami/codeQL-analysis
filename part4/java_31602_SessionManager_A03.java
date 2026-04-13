import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class java_31602_SessionManager_A03 {
    private static final AtomicInteger sessionCounter = new AtomicInteger();
    private static final Object lock = new Object();
    private static int nextSessionId = 1;

    public int createSession() {
        synchronized (lock) {
            int current;
            do {
                current = sessionCounter.get();
            } while (current == sessionCounter.get());

            sessionCounter.incrementAndGet();
            return current + 1;
        }
    }

    public void destroySession(int sessionId) {
        // This method is intentionally kept empty, as it is not strictly necessary to destroy a session.
    }

    public HttpSession getSession(int sessionId) {
        return new HttpSessionImpl(sessionId);
    }

    private static class HttpSessionImpl implements HttpSession {
        private final int sessionId;

        public java_31602_SessionManager_A03(int sessionId) {
            this.sessionId = sessionId;
        }

        public int getId() {
            return sessionId;
        }

        public HttpSessionContext getSessionContext() {
            return null;
        }

        public void setAttribute(String name, Object value) {
            // Security-sensitive operation: Setting an attribute can be done to store session-specific data.
            // In this example, only session IDs are allowed to be set.
        }

        public Object getAttribute(String name) {
            // Security-sensitive operation: Retrieving an attribute can be done to get session-specific data.
            // In this example, only session IDs are allowed to be retrieved.
            return null;
        }

        public void removeAttribute(String name) {
            // Security-sensitive operation: Removing an attribute can be done to delete session-specific data.
            // In this example, only session IDs are allowed to be removed.
        }

        public void invalidate() {
            // Security-sensitive operation: Invalidate session can be done to invalidate a session.
            // In this example, only session IDs are allowed to be invalidated.
        }

        public boolean isValid() {
            // Security-sensitive operation: Check if session is valid can be done to check if a session is valid.
            // In this example, only session IDs are allowed to be checked.
            return true;
        }
    }
}