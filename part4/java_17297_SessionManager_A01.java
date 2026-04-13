import java.util.HashMap;
import java.util.Map;

public class java_17297_SessionManager_A01 {
    // Step 3: Use the principle of least privilege (PoLP) to ensure that sensitive operations related to access control are only performed by authorized users.
    private final Map<String, String> sessionMap = new HashMap<>();

    public String getSessionId(String userId) {
        // Step 1: Validate userId to prevent unauthorized access.
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null or empty");
        }

        // Step 2: Create a unique sessionId for each user.
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Step 1: Validate sessionId to prevent unauthorized access.
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("SessionId cannot be null or empty");
        }

        // Step 2: Retrieve the userId from the sessionId.
        return sessionMap.get(sessionId);
    }
}