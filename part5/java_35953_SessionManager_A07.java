public class java_35953_SessionManager_A07 {
    // Session class to store session data
    private class Session {
        private String userName;

        public java_35953_SessionManager_A07(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }

    // Session service class to manage sessions
    private class SessionService {
        private List<Session> sessions;

        public java_35953_SessionManager_A07() {
            sessions = new ArrayList<>();
        }

        public Session createSession(String userName) {
            Session session = new Session(userName);
            sessions.add(session);
            return session;
        }

        public Session getSession(String userName) {
            for (Session session : sessions) {
                if (session.getUserName().equals(userName)) {
                    return session;
                }
            }
            return null;
        }

        public void deleteSession(String userName) {
            for (Session session : sessions) {
                if (session.getUserName().equals(userName)) {
                    sessions.remove(session);
                    return;
                }
            }
        }
    }

    private SessionService sessionService;

    public java_35953_SessionManager_A07() {
        sessionService = new SessionService();
    }

    public Session createSession(String userName) {
        return sessionService.createSession(userName);
    }

    public Session getSession(String userName) {
        return sessionService.getSession(userName);
    }

    public void deleteSession(String userName) {
        sessionService.deleteSession(userName);
    }
}