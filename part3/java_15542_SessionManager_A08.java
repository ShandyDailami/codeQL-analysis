import java.security.SecureRandom;

public class java_15542_SessionManager_A08 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final SecureRandom random = new SecureRandom();
    private final StringBuilder stringBuilder = new StringBuilder();

    private String generateSessionId() {
        for (int i = 0; i < 20; i++) {
            stringBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }

    public String createSession() {
        String sessionId = generateSessionId();
        // secure storage for sessionId
        return sessionId;
    }

    public void validateSession(String sessionId) {
        // Here, we're checking if the sessionId is valid and if it's active.
        // This is a placeholder and should be replaced with actual security-sensitive operations.
        if (sessionId == null || sessionId.length() == 0) {
            throw new SecurityException("Invalid session ID");
        }
    }
}