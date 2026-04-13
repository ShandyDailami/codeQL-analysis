public class java_12134_SessionManager_A08 {
    private String sessionToken;

    // create a new session for a user
    public void createSession(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    // invalidate the current session
    public void invalidateSession() {
        this.sessionToken = null;
    }

    // check if a session is valid
    public boolean isValidSession() {
        return this.sessionToken != null;
    }

    // get the session token
    public String getSessionToken() {
        return this.sessionToken;
    }
}