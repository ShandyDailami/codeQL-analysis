public class java_33957_SessionManager_A03 {
    private static ThreadLocal<Session> threadLocalSession = new ThreadLocal<>();

    public static void startSession(User user) {
        if (!validateUser(user)) {
            throw new SecurityException("Invalid user");
        }
        Session session = new Session();
        session.setUser(user);
        threadLocalSession.set(session);
    }

    public static Session getCurrentSession() {
        return threadLocalSession.get();
    }

    public static void endSession() {
        threadLocalSession.set(null);
    }

    private static boolean validateUser(User user) {
        // Add your logic to validate the user
        // This is a placeholder and should be replaced with actual validation logic
        return user != null && user.isValid();
    }
}

public class Session {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

public class User {
    private String username;
    private String password;

    public java_33957_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters

    public boolean isValid() {
        // Add your logic to validate the user
        // This is a placeholder and should be replaced with actual validation logic
        return true;
    }
}