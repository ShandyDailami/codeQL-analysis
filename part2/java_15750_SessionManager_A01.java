// This is a simple Java program to demonstrate the SessionManager using Java's built-in security features.

public class java_15750_SessionManager_A01 {
    private String name;
    private Session session;

    public java_15750_SessionManager_A01(String name) {
        this.name = name;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public String getName() {
        return name;
    }
}

public class Session {
    private String id;

    public java_15750_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

public class SessionManager {
    // Private map to hold all users.
    private Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public Session getSession(String userName) throws NoSuchElementException {
        User user = userMap.get(userName);
        if (user == null) {
            throw new NoSuchElementException("User not found");
        }
        return user.getSession();
    }
}