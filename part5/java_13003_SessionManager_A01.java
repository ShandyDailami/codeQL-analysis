public class java_13003_SessionManager_A01 {
    private static int sessionCount = 0;

    private java_13003_SessionManager_A01() {
        // Private constructor to prevent instantiation of the class
    }

    public static Session createSession() {
        Session session = getSessionFactory().openSession();
        sessionCount++;
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
            sessionCount--;
       
        }
    }

    public static void main(String[] args) {
        // Testing the SessionManager
        Session session1 = createSession();
        Session session2 = createSession();
        Session session3 = createSession();

        closeSession(session2);

        // Accessing sessionCount
        System.out.println("Session Count: " + sessionCount);
    }

    // Mock sessionFactory for testing
    private static SessionFactory getSessionFactory() {
        return new SessionFactory() {
            @Override
            public Session openSession() {
                return new Session() {
                    @Override
                    public void close() {
                        System.out.println("Closed Session");
                    }
                };
            }
        };
    }

    public static class Session {
        private boolean isOpen = true;

        public void close() {
            if (isOpen) {
                isOpen = false;
                System.out.println("Closed Session");
            }
        }
    }
}