import java.security.SecureRandom;
import java.util.Base64;

public class java_28638_SessionManager_A08 {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    private static final int MAX_ALLOWED_ID = 100;
    private static int currentId = 0;
    private static final int MAX_ALLOWED_SESSION_SIZE = 5;
    private static int currentSessionSize = 0;
    private static final int MIN_ALLOWED_SESSION_SIZE = 1;
    private static final int ID_LENGTH = 8;
    private static final String SESSION_PREFIX = "session-";
    private static final String TOKEN_SEPARATOR = "-";

    private static class Session {
        private String id;
        private int validity;

        private java_28638_SessionManager_A08(int validity) {
            this.validity = validity;
            this.id = createSessionId();
        }

        private String createSessionId() {
            byte[] randomNumber = getRandomNumber();
            return SESSION_PREFIX + base64Encoder.encodeToString(randomNumber);
        }

        private byte[] getRandomNumber() {
            byte[] number = new byte[ID_LENGTH];
            secureRandom.nextBytes(number);
            return number;
        }

        private void decreaseValidity() {
            this.validity--;
        }

        private boolean isValid() {
            return this.validity > 0;
        }
    }

    public static String createSession() {
        if (currentSessionSize < MAX_ALLOWED_SESSION_SIZE) {
            Session session = new Session(10);
            currentSessionSize++;
            return session.id;
        } else {
            throw new IllegalStateException("Session manager is full.");
        }
    }

    public static void validateSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null.");
        }

        Session session = findSession(sessionId);

        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID.");
        }

        if (!session.isValid()) {
            throw new IllegalStateException("Session is expired.");
        }
    }

    private static Session findSession(String sessionId) {
        // Implement your session finder logic here.
        // For simplicity, we just return null for now.
        return null;
    }

    public static void invalidateSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID cannot be null.");
        }

        Session session = findSession(sessionId);

        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID.");
        }

        session.decreaseValidity();
        currentSessionSize--;
    }
}