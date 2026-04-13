import java.util.HashMap;
import java.util.Map;

public class java_04504_SessionManager_A08 {
    private Map<String, String> credentials;

    public java_04504_SessionManager_A08() {
        this.credentials = new HashMap<>();
    }

    public void addCredentials(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return this.credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        SimpleSecurityManager securityManager = new SimpleSecurityManager();

        securityManager.addCredentials("user1", "password1");
        securityManager.addCredentials("user2", "password2");

        if (securityManager.authenticate("user1", "password1")) {
            System.out.println("User 1 is authenticated.");
        } else {
            System.out.println("User 1 is not authenticated.");
        }

        if (securityManager.authenticate("user2", "password2")) {
            System.out.println("User 2 is authenticated.");
        } else {
            System.out.println("User 2 is not authenticated.");
        }

        if (securityManager.authenticate("user3", "wrongPassword")) {
            System.out.println("User 3 is authenticated.");
        } else {
            System.out.println("User 3 is not authenticated.");
        }
    }
}