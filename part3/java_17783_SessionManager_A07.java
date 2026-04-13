import java.util.HashMap;
import java.util.Map;

public class java_17783_SessionManager_A07 {
    private Map<String, String> credentials;

    public java_17783_SessionManager_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            // If the user doesn't exist, return false
            return false;
        }

        if (expectedPassword.equals(password)) {
            // If the password is correct, return true
            return true;
        }

        // If the password is incorrect, return false
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addCredential("user1", "password1");
        sessionManager.addCredential("user2", "password2");

        boolean auth1 = sessionManager.authenticate("user1", "wrongPassword");
        boolean auth2 = sessionManager.authenticate("user1", "password1");
        boolean auth3 = sessionManager.authenticate("user3", "password1");

        System.out.println("Auth failed for user1 (expected false): " + auth1);
        System.out.println("Auth succeeded for user1 (expected true): " + auth2);
        System.out.println("Auth failed for user3 (expected false): " + auth3);
    }
}