public class java_28146_SessionManager_A08 {
    private User currentUser;

    public void openSession(User user) throws Exception {
        if (user != null && user.equals(currentUser)) {
            // Session is opened
            System.out.println("Session opened by: " + user.getName());
        } else {
            throw new Exception("Unauthorized access to session");
        }
    }

    public void closeSession() throws Exception {
        if (currentUser != null) {
            // Session is closed
            System.out.println("Session closed by: " + currentUser.getName());
        } else {
            throw new Exception("No session to close");
        }
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }
}

public class User {
    private String name;

    public java_28146_SessionManager_A08(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            User user1 = new User("User1");
            User user2 = new User("User2");

            sessionManager.setCurrentUser(user1);
            sessionManager.openSession(user1);
            sessionManager.closeSession();

            sessionManager.setCurrentUser(user2);
            sessionManager.openSession(user2); // This should fail

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}