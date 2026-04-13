import java.util.HashMap;
import java.util.Map;

public class java_30901_SessionManager_A07 {
    private Map<String, String> userDatabase;

    public java_30901_SessionManager_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        String correctPassword = userDatabase.get(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void printSession(String username) {
        System.out.println("Welcome, " + username + "!");
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String username = "user1";
        String password = "password1";

        if (sessionManager.authenticate(username, password)) {
            sessionManager.printSession(username);
        } else {
            System.out.println("Invalid username or password");
        }
    }
}