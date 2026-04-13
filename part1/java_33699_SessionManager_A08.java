import java.util.*;

public class java_33699_SessionManager_A08 {
    private List<User> users;

    public java_33699_SessionManager_A08() {
        users = new ArrayList<>();
        users.add(new User("user", "password", true)); // admin user
        users.add(new User("admin", "password", false)); // regular user
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.isAdmin();
            }
        }
        return false; // login failed
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        System.out.println("Is admin? " + securityManager.login("admin", "password"));
        System.out.println("Is admin? " + securityManager.login("user", "password"));
    }
}

class User {
    private String username;
    private String password;
    private boolean isAdmin;

    public java_33699_SessionManager_A08(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}