import java.util.ArrayList;
import java.util.List;

class java_05611_SessionManager_A07 {
    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}

class UserDatabase {
    private List<User> users;

    UserDatabase() {
        this.users = new ArrayList<>();
        this.users.add(new User("user1", "pass1"));
        this.users.add(new User("user2", "pass2"));
        this.users.add(new User("user3", "pass3"));
    }

    User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

class SecurityManager {
    private UserDatabase database;

    SecurityManager() {
        this.database = new UserDatabase();
    }

    User authenticate(String username, String password) {
        return database.findUser(username, password);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        User user = manager.authenticate("user1", "pass1");
        if (user != null) {
            System.out.println("Authenticated as user " + user.getUsername());
        } else {
            System.out.println("Authentication failed");
        }
    }
}