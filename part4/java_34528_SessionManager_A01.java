public class java_34528_SessionManager_A01 {

    private HashMap<String, Session> sessionMap;
    private HashMap<String, String> userPasswordMap;
    private static final String SALT = "SALT";

    public java_34528_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userPasswordMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, userId);
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    public String getSession(String sessionId) throws SessionNotFoundException {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session not found");
        }
        return session.getUserId();
    }

    public void deleteSession(String sessionId) {
        Session session = sessionMap.remove(sessionId);
        if (session != null) {
            System.out.println(session.getUserId() + " has been logged out");
        }
    }

    public void updatePassword(String userId, String newPassword) {
        userPasswordMap.put(userId, hashPassword(newPassword));
    }

    private String hashPassword(String password) {
        return DigestUtils.sha256Hex(password + SALT);
    }

    public boolean checkPassword(String userId, String password) {
        String hashedPassword = userPasswordMap.get(userId);
        return hashedPassword.equals(hashPassword(password + SALT));
    }

    private class Session {
        private String sessionId;
        private String userId;

        public java_34528_SessionManager_A01(String sessionId, String userId) {
            this.sessionId = sessionId;
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }
    }
}