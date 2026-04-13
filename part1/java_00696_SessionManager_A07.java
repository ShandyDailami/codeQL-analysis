import java.util.HashSet;
import java.util.Set;

public class java_00696_SessionManager_A07 {
    // A simple class to hold a user's name
    public static class User {
        public String name;

        public java_00696_SessionManager_A07(String name) {
            this.name = name;
        }
    }

    private Set<User> loggedInUsers = new HashSet<>();

    public void login(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        loggedInUsers.add(new User(userName));
    }

    public Set<User> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void logout(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        loggedInUsers.removeIf(user -> user.name.equals(userName));
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.login("Alice");
        sessionManager.login("Bob");
        sessionManager.login("Charlie");

        System.out.println("Logged in users: " + sessionManager.getLoggedInUsers());

        sessionManager.logout("Bob");

        System.out.println("Logged in users after logout: " + sessionManager.getLoggedInUsers());
    }
}