public class java_24862_SessionManager_A01 {
    private static final String SESSION_ID_PATTERN = "A01_";

    public boolean isSessionIDBroken(String sessionID) {
        // Check if session ID starts with A01_
        if (!sessionID.startsWith(SESSION_ID_PATTERN)) {
            return false; // Session ID is not broken
        }

        // Check if session ID contains more characters after A01_
        if (sessionID.substring(SESSION_ID_PATTERN.length()).length() > 0) {
            return true; // Session ID is broken
        }

        return false; // Session ID is not broken
    }
}