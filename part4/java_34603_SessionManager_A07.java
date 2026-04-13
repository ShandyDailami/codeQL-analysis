import java.util.HashMap;

public class java_34603_SessionManager_A07 {

    private HashMap<String, String> users;
    private HashMap<String, String> passwords;

    public java_34603_SessionManager_A07() {
        users = new HashMap<>();
        passwords = new HashMap<>();
    }

    public void addUser(String username, String password) {
        users.put(username, password);
        passwords.put(username, password);
    }

    public void login(String username, String password) throws AuthFailureException {
        if (!users.containsKey(username) || !users.get(username).equals(password)) {
            throw new AuthFailureException();
        }
    }
}

class AuthFailureException extends Exception {
    // Exception for unauthorized access
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        try {
            sessionManager.login("user1", "password1");
            sessionManager.login("user2", "password2");
            System.out.println("Successfully logged in!");
        } catch (AuthFailureException e) {
            System.out.println("Login failed!");
        }
    }
}