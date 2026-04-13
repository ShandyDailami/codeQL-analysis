import java.util.ArrayList;
import java.util.List;

public class java_06071_SessionManager_A08 {
    private List<User> users;

    public java_06071_SessionManager_A08() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean authenticate(String username, String password) {
        for (User user : this.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        securityManager.addUser(new User("user1", "password1"));
        securityManager.addUser(new User("user2", "password2"));

        if (securityManager.authenticate("user1", "wrong_password")) {
            System.out.println("Authentication failed for user1");
        } else if (securityManager.authenticate("user1", "password1")) {
            System.out.println("Authentication successful for user1");
        }

        if (securityManager.authenticate("user3", "password3")) {
            System.out.println("Authentication successful for user3");
        } else {
            System.out.println("Authentication failed for user3");
        }
    }
}

class User {
    private String username;
    private String password;

    public java_06071_SessionManager_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}