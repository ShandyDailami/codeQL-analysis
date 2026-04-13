import java.util.HashMap;
import java.util.Map;

public class java_23415_SessionManager_A07 {

    private Map<String, String> users;

    public java_23415_SessionManager_A07() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        return users.get(username) != null && users.get(username).equals(password);
    }

    public String getPage(String username, String password) {
        if (!authenticate(username, password)) {
            return "Access denied!";
        }
        return "Welcome back!";
    }

    // The main method for testing
    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        System.out.println(manager.getPage("user1", "password1"));
        System.out.println(manager.getPage("user2", "wrongpassword"));
        System.out.println(manager.getPage("invaliduser", "invalidpassword"));
    }

}