public class java_12474_SessionManager_A08 {

    private static SessionManager instance;
    private static List<User> loggedUsers;

    private java_12474_SessionManager_A08() {
        loggedUsers = new ArrayList<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(String username, String password) throws Exception {
        // A very basic implementation of a login process. In a real-world application,
        // this would involve checking against a database of known users.
        if ("admin".equals(username) && "password".equals(password)) {
            loggedUsers.add(new User(username));
        } else {
            throw new Exception("Invalid username or password");
        }
    }

    public void logout(String username) throws Exception {
        if (loggedUsers.isEmpty()) {
            throw new Exception("No user logged in");
        } else if (!loggedUsers.removeIf(user -> user.username.equals(username))) {
            throw new Exception("User not logged in");
        }
    }

    public static class User {
        public String username;

        public java_12474_SessionManager_A08(String username) {
            this.username = username;
        }
    }
}