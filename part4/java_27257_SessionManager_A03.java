import java.util.ArrayList;
import java.util.List;

public class java_27257_SessionManager_A03 {
    private List<User> loggedUsers;

    public java_27257_SessionManager_A03() {
        this.loggedUsers = new ArrayList<>();
    }

    public void login(User user) {
        // Simulating login with a secure method
        if (isUserLoggedIn(user)) {
            System.out.println("User already logged in");
        } else {
            loggedUsers.add(user);
            System.out.println("User logged in successfully");
        }
    }

    public void logout(User user) {
        // Simulating logout with a secure method
        if (!isUserLoggedIn(user)) {
            System.out.println("User already logged out");
        } else {
            loggedUsers.remove(user);
            System.out.println("User logged out successfully");
        }
    }

    private boolean isUserLoggedIn(User user) {
        // Simulating the security operation
        // Replacing sensitive information with fake information
        return loggedUsers.contains(user);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.login(new User("admin"));
        manager.login(new User("admin"));
        manager.logout(new User("admin"));
        manager.logout(new User("admin"));
    }
}

class User {
    private String username;

    public java_27257_SessionManager_A03(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username != null ? username.equals(user.username) : user.username == null;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }
}