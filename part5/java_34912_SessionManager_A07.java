import java.util.HashSet;
import java.util.Set;

public class java_34912_SessionManager_A07 {
    private Set<UserSession> activeSessions;

    public java_34912_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void addSession(UserSession userSession) {
        activeSessions.add(userSession);
    }

    public void removeSession(UserSession userSession) {
        activeSessions.remove(userSession);
    }

    public Set<UserSession> getActiveSessions() {
        return activeSessions;
    }

    public static class UserSession {
        private String userId;
        private boolean isLoggedIn;

        public java_34912_SessionManager_A07(String userId) {
            this.userId = userId;
            this.isLoggedIn = false;
        }

        public String getUserId() {
            return userId;
        }

        public boolean isLoggedIn() {
            return isLoggedIn;
        }

        public void login() {
            if (!isLoggedIn) {
                isLoggedIn = true;
                System.out.println("User " + userId + " logged in successfully.");
            } else {
                System.out.println("User " + userId + " already logged in.");
            }
        }

        public void logout() {
            if (isLoggedIn) {
                isLoggedIn = false;
                System.out.println("User " + userId + " logged out successfully.");
            } else {
                System.out.println("User " + userId + " already logged out.");
            }
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        UserSession user1 = new UserSession("User1");
        UserSession user2 = new UserSession("User2");
        UserSession user3 = new UserSession("User3");

        sessionManager.addSession(user1);
        sessionManager.addSession(user2);
        sessionManager.addSession(user3);

        user1.login();
        user2.login();
        user3.logout();

        for (UserSession session : sessionManager.getActiveSessions()) {
            System.out.println("User: " + session.getUserId() + ", isLoggedIn: " + session.isLoggedIn());
        }
    }
}