import java.util.HashSet;
import java.util.Set;

public class java_22184_SessionManager_A07 {
    private Set<Session> activeSessions;

    public java_22184_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void startSession(String userName) {
        Session session = new Session(userName);
        activeSessions.add(session);
    }

    public void endSession(String userName) {
        Session session = findSession(userName);
        if(session != null) {
            activeSessions.remove(session);
        }
    }

    public Session findSession(String userName) {
        for(Session session : activeSessions) {
            if(session.getUserName().equals(userName)) {
                return session;
            }
        }
        return null;
    }

    public void checkSessionExpiration() {
        for(Session session : activeSessions) {
            if(!session.isActive()) {
                System.out.println("Session for user " + session.getUserName() + " is expired.");
                endSession(session.getUserName());
            }
        }
    }

    // Session class
    private class Session {
        private String userName;
        private boolean isActive;

        public java_22184_SessionManager_A07(String userName) {
            this.userName = userName;
            this.isActive = true;
        }

        public String getUserName() {
            return userName;
        }

        public boolean isActive() {
            return isActive;
        }

        public void setInactive() {
            isActive = false;
        }
    }
}