public class java_34648_SessionManager_A03 {
    private static int count = 0; // Count of sessions
    private static SessionManager instance; // Singleton instance
    private int id; // Unique ID for each session
    private User user; // User who owns this session

    private java_34648_SessionManager_A03(User user) {
        this.id = ++count; // Assign a unique ID
        this.user = user;
    }

    public static SessionManager getInstance(User user) {
        if (instance == null || instance.user != user) {
            instance = new SessionManager(user);
        }
        return instance;
    }

    public void startSession(String sessionName) {
        // Security sensitive operation: Log the session start and session name
        System.out.println(String.format("Session %d started for user %s with name %s", id, user.getUsername(), sessionName));
    }

    public void endSession() {
        // Security sensitive operation: Log the session end
        System.out.println(String.format("Session %d ended for user %s", id, user.getUsername()));
    }
}

public class User {
    private String username;
    private String password;

    public java_34648_SessionManager_A03(String username, String password) {
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