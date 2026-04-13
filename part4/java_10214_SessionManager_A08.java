public class java_10214_SessionManager_A08 {
    private String id;
    private User user;

    // Constructor, Getters and Setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

public class User {
    private String name;

    // Constructor and Getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SessionManager {
    private static HashMap<String, CustomSession> sessions = new HashMap<>();

    public static void main(String[] args) {
        User user = new User();
        user.setName("User1");

        CustomSession session = new CustomSession();
        session.setId("1");
        session.setUser(user);

        sessions.put(session.getId(), session);

        // Print session details
        System.out.println("Session ID: " + session.getId());
        System.out.println("User Name: " + session.getUser().getName());

        // Check if session exists
        if (sessions.containsKey(session.getId())) {
            System.out.println("Session exists.");
        } else {
            System.out.println("Session does not exist.");
        }

        // Access session details after session has been closed
        try {
            System.out.println("Session user name: " + sessions.get(session.getId()).getUser().getName());
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}