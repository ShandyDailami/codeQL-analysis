public class java_23109_SessionManager_A01 {
    private static final int MAX_SESSIONS = 100;
    private static int sessionCount = 0;

    private static String[] sessions = new String[MAX_SESSIONS];

    public static String createSession() {
        if (sessionCount >= MAX_SESSIONS) {
            throw new RuntimeException("Maximum sessions reached.");
        }

        String sessionId = Integer.toString(sessionCount);
        sessions[sessionCount++] = sessionId;

        return sessionId;
    }

    public static String getSession(String sessionId) {
        for (int i = 0; i < sessionCount; i++) {
            if (sessions[i].equals(sessionId)) {
                return sessions[i];
            }
        }

        throw new RuntimeException("Session not found.");
    }
}