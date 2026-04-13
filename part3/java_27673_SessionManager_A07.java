import java.util.HashMap;
import java.util.Map;

public class java_27673_SessionManager_A07 {

    private Map<String, String> credentials;
    private Map<String, String> sessionMap;

    public java_27673_SessionManager_A07() {
        credentials = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        credentials.put(username, password);
    }

    public String login(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            sessionMap.put(username, "Active");
            return "Welcome, " + username + "!";
        } else {
            sessionMap.put(username, "Inactive");
            return "Invalid username or password!";
        }
    }

    public String getSessionStatus(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            return "No active session!";
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.addCredential("user1", "password1");
        manager.addCredential("user2", "password2");

        System.out.println(manager.login("user1", "password1"));
        System.out.println(manager.getSessionStatus("user1"));
        System.out.println(manager.getSessionStatus("user2"));
        System.out.println(manager.login("user1", "wrongpassword"));
        System.out.println(manager.getSessionStatus("user1"));
    }
}