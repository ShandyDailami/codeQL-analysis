import java.util.*;

public class java_34503_SessionManager_A08 {
    private Map<String, Session> sessions = new HashMap<>();

    public class Session {
        private String id;
        private User user;

        public java_34503_SessionManager_A08(String id, User user) {
            this.id = id;
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public User getUser() {
            return user;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    public class User {
        private String name;
        private String password;

        public java_34503_SessionManager_A08(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public java_34503_SessionManager_A08() {
    }

    public Session createSession(String userName, String password) {
        if (isValidUser(userName, password)) {
            String id = UUID.randomUUID().toString();
            Session session = new Session(id, new User(userName, password));
            sessions.put(id, session);
            return session;
        } else {
            return null;
        }
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    private boolean isValidUser(String userName, String password) {
        // Simulate checking against a database of users
        return userName.equals("admin") && password.equals("password");
    }
}