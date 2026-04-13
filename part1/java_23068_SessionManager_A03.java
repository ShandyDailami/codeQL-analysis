public class java_23068_SessionManager_A03 {
    private String username;
    private String password;

    public java_23068_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
}

public class SessionManager {
    private HashMap<String, User> users;

    public java_23068_SessionManager_A03() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void validateUser(String username, String password) {
        User user = getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("User authenticated successfully");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}