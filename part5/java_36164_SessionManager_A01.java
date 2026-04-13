public class java_36164_SessionManager_A01 {

    private static final Logger log = LoggerFactory.getLogger(SessionManager.class);
    private static final String secretKey = "ThisIsASecretKey";

    // In-memory session store
    private static Map<String, SessionData> sessionStore = new HashMap<>();

    public static void startSession(String sessionId, SessionData sessionData) {
        if (sessionStore.containsKey(sessionId)) {
            log.warn("Session already exists with id: {}", sessionId);
        } else {
            sessionStore.put(sessionId, sessionData);
        }
    }

    public static void endSession(String sessionId) {
        if (sessionStore.containsKey(sessionId)) {
            sessionStore.remove(sessionId);
        } else {
            log.warn("Trying to end non-existent session with id: {}", sessionId);
        }
    }

    public static SessionData getSessionData(String sessionId) {
        if (sessionStore.containsKey(sessionId)) {
            return sessionStore.get(sessionId);
        } else {
            log.warn("Trying to access non-existent session with id: {}", sessionId);
            return null;
        }
    }

    public static boolean isValidSession(String sessionId, String sessionKey) {
        if (!sessionStore.containsKey(sessionId)) {
            log.warn("Invalid session with id: {}", sessionId);
            return false;
        }

        SessionData sessionData = sessionStore.get(sessionId);
        if (!sessionData.getSessionKey().equals(sessionKey)) {
            log.warn("Invalid session key for session id: {}", sessionId);
            return false;
        }

        return true;
    }
}

class SessionData {
    private String sessionKey;

    // Constructor, getters and setters
}