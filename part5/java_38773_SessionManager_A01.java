public class java_38773_SessionManager_A01 {
    private static final String SESSION_ID = "sessionId";

    // Store all sessions in a Map for easy lookup
    private Map<String, Session> sessionMap;

    public java_38773_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(User user) {
        // Create a session for the user
        Session session = new Session(user);

        // Generate a session ID for the session
        String sessionId = UUID.randomUUID().toString();

        // Store the session in the session map
        sessionMap.put(sessionId, session);

        // Store the session ID in a cookie for the user
        Cookie cookie = new Cookie(SESSION_ID, sessionId);
        // Setting max age to 1 hour
        cookie.setMaxAge(60 * 60);
        // Adding the cookie to the response
        CookieManager cookieManager = new CookieManager();
        cookieManager.addCookie(cookie);

        return sessionId;
    }

    public User getSession(String sessionId) {
        // Check if the session exists in the session map
        if (!sessionMap.containsKey(sessionId)) {
            return null;
        }

        // Get the session from the session map
        Session session = sessionMap.get(sessionId);

        // Check if the session is valid
        if (session == null || session.isExpired()) {
            return null;
        }

        // Return the user from the session
        return session.getUser();
    }

    public void destroySession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }

    private class Session {
        private User user;
        private Date creationTime;

        public java_38773_SessionManager_A01(User user) {
            this.user = user;
            this.creationTime = new Date();
        }

        public User getUser() {
            return user;
        }

        public boolean isExpired() {
            Date now = new Date();
            long diff = now.getTime() - creationTime.getTime();
            long expirationTime = 60 * 1000;  // 1 minute
            return diff > expirationTime;
        }
    }
}