import java.util.HashMap;
import java.util.Map;

public class java_39562_SessionManager_A01 implements SessionFactory {
    private Map<String, User> users;

    public java_39562_SessionManager_A01() {
        users = new HashMap<>();
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public void removeUser(String username) {
        users.remove(username);
    }

    public boolean isAuthenticated(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void logout(String username) {
        User user = users.get(username);
        if (user != null) {
            user.setAuthenticated(false);
        }
    }

    @Override
    public Session createSession() {
        Session session = new SessionImpl(this);
        return session;
    }

    @Override
    public void destroySession(Session session) {
        // No implementation needed here.
    }

    private class User {
        private String username;
        private String password;
        private boolean isAuthenticated;

        public java_39562_SessionManager_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setAuthenticated(boolean authenticated) {
            isAuthenticated = authenticated;
        }

        public boolean isAuthenticated() {
            return isAuthenticated;
        }
    }
}