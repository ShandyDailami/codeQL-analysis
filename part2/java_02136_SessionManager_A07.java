import java.util.HashMap;
import java.util.Map;

public class java_02136_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_02136_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean isAuthenticated(String username, String password) {
        String expectedPassword = userMap.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public void authenticate(String username, String password) throws AuthFailureException {
        if (!isAuthenticated(username, password)) {
            throw new AuthFailureException();
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        sm.addUser("alice", "password");

        try {
            sm.authenticate("alice", "password"); // This should not throw an exception
            System.out.println("User is authenticated successfully");
        } catch (AuthFailureException e) {
            System.out.println("User authentication failed");
        }

        try {
            sm.authenticate("bob", "password"); // This should throw an exception
            System.out.println("User is authenticated successfully");
        } catch (AuthFailureException e) {
            System.out.println("User authentication failed");
        }
    }
}

class AuthFailureException extends Exception {
    // This exception is used to indicate that authentication failed
}