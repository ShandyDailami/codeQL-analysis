import java.util.ArrayList;
import java.util.List;

public class java_23216_SessionManager_A07 {

    private List<Session> sessions;

    public java_23216_SessionManager_A07() {
        sessions = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public static class Session {

        private String id;
        private User user;

        public java_23216_SessionManager_A07(String id) {
            this.id = id;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public static class User {

            private String username;
            private String password;

            public java_23216_SessionManager_A07(String username, String password) {
                this.username = username;
                this.password = password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPassword() {
                return password;
            }

            public String getUsername() {
                return username;
            }
        }
    }
}