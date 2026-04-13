import java.util.HashMap;
import java.util.Map;

public class java_37764_SessionManager_A07 {
    private Map<String, String> userData;

    public java_37764_SessionManager_A07() {
        userData = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userData.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return userData.get(username).equals(password);
    }

    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        manager.addUser("alice", "password");
        manager.addUser("bob", "password");

        boolean isAuthenticated = manager.authenticate("alice", "password");
        if(isAuthenticated) {
            System.out.println("Welcome Alice, you are authenticated.");
        } else {
            System.out.println("Access denied for Alice.");
        }

        isAuthenticated = manager.authenticate("alice", "wrongpassword");
        if(isAuthenticated) {
            System.out.println("Welcome Alice, you are authenticated.");
        } else {
            System.out.println("Access denied for Alice.");
        }

        isAuthenticated = manager.authenticate("bob", "password");
        if(isAuthenticated) {
            System.out.println("Welcome Bob, you are authenticated.");
        } else {
            System.out.println("Access denied for Bob.");
        }
    }
}