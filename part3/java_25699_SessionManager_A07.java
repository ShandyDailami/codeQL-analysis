import java.util.HashMap;
import java.util.Map;

public class java_25699_SessionManager_A07 {

    private Map<String, String> userCredentials;

    public java_25699_SessionManager_A07() {
        this.userCredentials = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser("alice", "password1");
        sessionManager.addUser("bob", "password2");

        boolean isAuthenticated = sessionManager.authenticate("alice", "password1");
        if (isAuthenticated) {
            System.out.println("Alice is authenticated!");
        } else {
            System.out.println("Authentication failed!");
        }

        isAuthenticated = sessionManager.authenticate("bob", "wrongpassword");
        if (isAuthenticated) {
            System.out.println("Bob is authenticated!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}