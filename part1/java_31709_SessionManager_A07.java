import javax.security.auth.login.FailedLoginException;

public class java_31709_SessionManager_A07 {

    private static final String SESSION_ID = "sessionId";
    private static final String USERNAME = "username";

    private static class SingletonHolder {
        private static final UserSessionManager INSTANCE = new UserSessionManager();
    }

    private java_31709_SessionManager_A07() {
        // Private constructor to prevent instantiation from other classes
    }

    public static UserSessionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String createSession(String username) {
        // Create a new session ID
        String sessionId = java.util.UUID.randomUUID().toString();

        // Set the session ID and username in the session
        HttpSession session = getHttpSession();
        session.setAttribute(SESSION_ID, sessionId);
        session.setAttribute(USERNAME, username);

        return sessionId;
    }

    public String getSessionUsername(String sessionId) {
        // Get the username from the session
        HttpSession session = getHttpSession();
        return (String) session.getAttribute(USERNAME);
    }

    public boolean validateSession(String sessionId, String expectedUsername) {
        // Validate the session
        HttpSession session = getHttpSession();
        String username = (String) session.getAttribute(USERNAME);

        if (username == null || !username.equals(expectedUsername)) {
            throw new FailedLoginException("Invalid session");
        }

        String expectedSessionId = (String) session.getAttribute(SESSION_ID);

        if (expectedSessionId == null || !expectedSessionId.equals(sessionId)) {
            throw new FailedLoginException("Invalid session");
        }

        return true;
    }

    private HttpSession getHttpSession() {
        // This method is left to you, you might use a Spring context or any other library
        // to get the current HttpSession
        // For the sake of simplicity, this example uses a placeholder
        return null;
    }
}