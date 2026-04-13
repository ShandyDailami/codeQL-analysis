public class java_22936_SessionManager_A03 {
    private List<User> users;

    public java_22936_SessionManager_A03() {
        users = new ArrayList<>();
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

public class User {
    private String username;
    private String password;

    public java_22936_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_22936_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public User authenticate(String username, String password) {
        User user = securityManager.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}