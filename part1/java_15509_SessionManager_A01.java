import java.util.HashMap;
import java.util.Map;

public class java_15509_SessionManager_A01 {

    // This is a simple in-memory session store. In a real-world application, you would likely use a database.
    private Map<String, Session> sessions;

    public java_15509_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    // A session represents a user logged into the system.
    public class Session {
        private String userId;

        public java_15509_SessionManager_A01(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }
    }

    // This method is used to create a new session. It should check if the user is authorized to create a new session.
    public Session createSession(String userId) {
        if (isUserAuthorized(userId)) {
            Session session = new Session(userId);
            sessions.put(userId, session);
            return session;
        } else {
            throw new UnauthorizedException("User is not authorized to create a session.");
        }
    }

    // This method is used to get an existing session. It should check if the user is authorized to get the session.
    public Session getSession(String userId) {
        if (isUserAuthorized(userId)) {
            return sessions.get(userId);
        } else {
            throw new UnauthorizedException("User is not authorized to get a session.");
        }
    }

    // This method is used to close the session. It should check if the user is authorized to close the session.
    public void closeSession(String userId) {
        if (isUserAuthorized(userId)) {
            sessions.remove(userId);
        } else {
            throw new UnauthorizedException("User is not authorized to close a session.");
        }
    }

    // This method is used to check if a user is authorized to perform certain actions. In a real-world application,
    // you would likely use a secure authentication system to determine if a user is authorized.
    private boolean isUserAuthorized(String userId) {
        // This is a simple example of an authentication system. In a real-world application, you would likely use
        // a secure authentication system to determine if a user is authorized.
        return true;
    }
}