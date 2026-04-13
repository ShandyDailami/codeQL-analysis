public class java_20697_SessionManager_A01 {
    private User user;

    public java_20697_SessionManager_A01(User user) {
        this.user = user;
    }

    public boolean openSession() {
        // Simulate opening a session by logging the user in
        System.out.println("Session opened for user: " + user.getName());
        return true;
    }

    public boolean closeSession() {
        // Simulate closing a session by logging the user out
        System.out.println("Session closed for user: " + user.getName());
        return true;
    }

    public void addUser(User user) {
        // Simulate adding a user to the session
        System.out.println("User: " + user.getName() + " added to session");
    }
}

public class User {
    private String name;

    public java_20697_SessionManager_A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        // Simulate creating a user
        User user = new User("John Doe");

        // Simulate creating a session for the user
        Session session = new Session(user);

        // Simulate opening the session
        session.openSession();

        // Simulate adding the user to the session
        session.addUser(user);

        // Simulate closing the session
        session.closeSession();
    }
}