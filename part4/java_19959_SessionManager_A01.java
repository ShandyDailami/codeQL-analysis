import java.util.HashMap;
import java.util.Map;

public class java_19959_SessionManager_A01 {

    private Map<String, String> userDatabase;
    private Map<String, String> passwordDatabase;

    public java_19959_SessionManager_A01() {
        userDatabase = new HashMap<>();
        passwordDatabase = new HashMap<>();

        // populate userDatabase with dummy data
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        userDatabase.put("user3", "password3");

        // populate passwordDatabase with dummy data
        passwordDatabase.put("password1", "user1");
        passwordDatabase.put("password2", "user2");
        passwordDatabase.put("password3", "user3");
    }

    public String getPassword(String user) {
        return userDatabase.get(user);
    }

    public String getUser(String password) {
        return passwordDatabase.get(password);
    }

    public boolean authenticate(String user, String password) {
        return userDatabase.get(user).equals(password) && passwordDatabase.get(password).equals(user);
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_19959_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String login(String user, String password) {
        if (securityManager.authenticate(user, password)) {
            return "Successfully logged in as " + user;
        } else {
            return "Failed to log in";
        }
    }
}

public class Main {

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);

        System.out.println(sessionManager.login("user1", "password1"));
        System.out.println(sessionManager.login("user3", "password3"));
        System.out.println(sessionManager.login("user4", "password4"));
    }
}