import java.util.HashMap;
import java.util.Map;

public class java_37485_SessionManager_A01 {
    private String username;
    private String password;

    public java_37485_SessionManager_A01(String username, String password) {
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

public class SessionManager {
    private Map<String, User> users = new HashMap<>();

    public java_37485_SessionManager_A01() {
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    public void login(String username, String password) throws Exception {
        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Invalid username or password");
        }
        System.out.println("Logged in as " + username);
    }
}