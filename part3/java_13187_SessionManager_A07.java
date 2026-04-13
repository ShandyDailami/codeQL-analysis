public class java_13187_SessionManager_A07 {
    private String userName;
    private String sessionId;

    public java_13187_SessionManager_A07(String userName, String sessionId) {
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getSessionId() {
        return sessionId;
    }
}

public class AuthFailureEventLogger {
    public void logEvent(AuthenticationFailureEvent event) {
        System.out.println("User: " + event.getUserName() +
                ", Session ID: " + event.getSessionId() +
                ", Authentication failed. Event logged...");
    }
}

public class SessionManager {
    private AuthFailureEventLogger authFailureEventLogger;

    public java_13187_SessionManager_A07(AuthFailureEventLogger authFailureEventLogger) {
        this.authFailureEventLogger = authFailureEventLogger;
    }

    public void manageSession(String userName, String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            System.out.println("Session is not valid. Not managing session...");
            return;
        }

        authFailureEventLogger.logEvent(new AuthenticationFailureEvent(userName, sessionId));
    }
}