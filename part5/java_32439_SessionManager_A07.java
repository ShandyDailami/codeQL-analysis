public class java_32439_SessionManager_A07 {

    private static Set<String> authenticatedUsers;

    static {
        authenticatedUsers = new HashSet<>();
    }

    public static void main(String[] args) {
        // Creating a new session
        Session session = createSession();

        // User A tries to access resource
        if (session.isAuthenticated()) {
            System.out.println("User A successfully logged in");
            tryAccessResource(session);
        } else {
            System.out.println("User A must be logged in to access the resource");
        }

        // User B tries to access resource
        Session sessionB = createSession();
        sessionB.setAuthenticated(true);
        if (sessionB.isAuthenticated()) {
            System.out.println("User B successfully logged in");
            tryAccessResource(sessionB);
        } else {
            System.out.println("User B must be logged in to access the resource");
        }
    }

    private static Session createSession() {
        return new SessionImpl();
    }

    private static void tryAccessResource(Session session) {
        try {
            System.out.println("Attempting to access resource...");
            session.access("Accessing the resource...");
            System.out.println("Successfully accessed resource!");
        } catch (SecurityFailure e) {
            System.out.println("Access denied!");
        }
    }

    public static class SessionImpl implements Session {

        private boolean authenticated = false;

        @Override
        public boolean isAuthenticated() {
            return authenticated;
        }

        @Override
        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

        @Override
        public void access(String message) {
            if (!authenticated) {
                throw new SecurityFailure("Attempted to access resource without authentication");
            }
        }
    }

    public static class Session {

        public boolean isAuthenticated();

        public void setAuthenticated(boolean authenticated);

        public void access(String message);
    }

    public static class SecurityFailure extends RuntimeException {

        public java_32439_SessionManager_A07(String message) {
            super(message);
        }
    }
}