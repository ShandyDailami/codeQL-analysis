import java.util.HashMap;
import java.util.Map;

public class java_06964_SessionManager_A07 {

    private Map<String, String> userDB;

    public java_06964_SessionManager_A07() {
        userDB = new HashMap<>();
        userDB.put("user1", "password1");
        userDB.put("user2", "password2");
        userDB.put("user3", "password3");
    }

    public String authenticate(String username, String password) {
        String expectedPassword = userDB.get(username);

        if (expectedPassword == null || !expectedPassword.equals(password)) {
            throw new AuthenticationFailureException();
        }

        return "User " + username + " is now logged in.";
    }

    public String logout(String username) {
        return "User " + username + " is now logged out.";
    }

    public static class AuthenticationFailureException extends RuntimeException {
        public java_06964_SessionManager_A07() {
            super("Authentication failed.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        try {
            String message = manager.authenticate("user1", "wrongpassword");
            System.out.println(message);
        } catch (SessionManager.AuthenticationFailureException e) {
            System.out.println(e.getMessage());
        }

        try {
            String message = manager.authenticate("user2", "password2");
            System.out.println(message);
        } catch (SessionManager.AuthenticationFailureException e) {
            System.out.println(e.getMessage());
        }

        try {
            String message = manager.logout("user1");
            System.out.println(message);
        } catch (SessionManager.AuthenticationFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}