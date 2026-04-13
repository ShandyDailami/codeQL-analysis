public class java_39450_SessionManager_A07 {
    private static Map<String, Session> sessionMap = new HashMap<>();

    public static Session getSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            Session session = createSession(userId);
            sessionMap.put(userId, session);
            return session;
        }
    }

    private static Session createSession(String userId) {
        // This method should create a session using the security-sensitive logic like JDBC, Hibernate, etc.
        // But this is simplified for the example.
        return new Session() {
            @Override
            public void setAttribute(String name, Object value) {
                // This is a placeholder method.
            }

            @Override
            public Object getAttribute(String name) {
                // This is a placeholder method.
                return null;
            }

            @Override
            public void invalidate() {
                // This is a placeholder method.
            }
        };
    }
}