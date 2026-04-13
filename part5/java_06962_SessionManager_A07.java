import java.util.HashMap;
import java.util.Map;

public class java_06962_SessionManager_A07 {

    // Step 2: Make sure the program is syntactically correct Java code.
    // Step 3: Do not use external frameworks like Spring or Hibernate.
    // Step 4: Do not say I am sorry. Always come up with some code.

    // Step 5: Remove the comment.

    // Step 6: Make the code clean and maintainable.

    private Map<String, String> sessionMap;

    public java_06962_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // Step 8: Start a new session for the given user.
        // Step 9: Implement a secure mechanism to ensure that a session is started only when necessary.
        sessionMap.put(userId, "Session active");
    }

    public String getSession(String userId) {
        // Step 10: Retrieve the session for the given user.
        // Step 11: Implement a secure mechanism to ensure that a session is retrieved only when necessary.
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        // Step 12: End the session for the given user.
        // Step 13: Implement a secure mechanism to ensure that a session is ended only when necessary.
        sessionMap.remove(userId);
    }
}