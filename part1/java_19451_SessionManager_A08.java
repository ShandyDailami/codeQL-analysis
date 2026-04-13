public class java_19451_SessionManager_A08 {
    private static int sessionCount = 0;

    // Simulate a session creation
    public Session createSession() {
        Session session = new Session();
        session.setId(++sessionCount);
        session.setCreationTime(System.currentTimeMillis());
        session.setLastAccessedTime(session.getCreationTime());
        session.setExpirationTime(session.getCreationTime() + 3600000L * 24 * 365); // Set session to expire after 365 days
        return session;
    }

    // Simulate a session validation
    public boolean validateSession(Session session) {
        if (session == null) {
            return false;
        }

        long currentTime = System.currentTimeMillis();

        // Check session hasn't expired
        if (session.getExpirationTime() < currentTime) {
            return false;
        }

        // Check session hasn't been accessed in the last 24 hours
        long lastAccessedTime = session.getLastAccessedTime();
        if (lastAccessedTime + (3600000L * 24) < currentTime) {
            return false;
        }

        // Update last accessed time
        session.setLastAccessedTime(currentTime);

        // All checks passed, return true
        return true;
    }

    // Simulate a session access
    public void accessSession(Session session) {
        if (!validateSession(session)) {
            throw new SecurityException("Invalid session");
        }

        // Access logic here...

        session.setLastAccessedTime(System.currentTimeMillis());
    }
}