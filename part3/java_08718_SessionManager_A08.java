import java.util.*;

public class java_08718_SessionManager_A08 {
    private static final Map<UUID, String> sessions = new HashMap<>();
    private static final PasswordHasher passwordHasher = new PasswordHasher();

    public static UUID createSession(String password) {
        UUID sessionId = UUID.randomUUID();
        String hashedPassword = passwordHasher.hash(password);
        sessions.put(sessionId, hashedPassword);
        return sessionId;
    }

    public static void deleteSession(UUID sessionId) {
        sessions.remove(sessionId);
    }

    public static boolean isValidSession(UUID sessionId, String password) {
        String hashedPassword = sessions.get(sessionId);
        if (hashedPassword == null) {
            return false;
        }
        return passwordHasher.verify(password, hashedPassword);
    }
}