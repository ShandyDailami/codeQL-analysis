public class java_38688_SessionManager_A01 {
    private static final ThreadLocal<Integer> sessionIdThreadLocal = new ThreadLocal<Integer>();

    public static void startSession(int sessionId) {
        if (sessionIdThreadLocal.get() != null) {
            throw new IllegalStateException("Session already started");
        }
        sessionIdThreadLocal.set(sessionId);
    }

    public static int getSessionId() {
        Integer sessionId = sessionIdThreadLocal.get();
        if (sessionId == null) {
            throw new IllegalStateException("No session started");
        }
        return sessionId;
    }

    public static void endSession(int sessionId) {
        if (sessionIdThreadLocal.get() != sessionId) {
            throw new IllegalStateException("Illegal session state");
        }
        sessionIdThreadLocal.set(null);
    }
}