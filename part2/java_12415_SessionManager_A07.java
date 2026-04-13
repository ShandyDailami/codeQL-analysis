import java.util.HashMap;
import java.util.Map;

public class java_12415_SessionManager_A07 {

    // This is a simple in-memory store for users and their passwords.
    // In a real system, this data would be fetched from a database.
    private Map<String, String> userStore;

    public java_12415_SessionManager_A07() {
        this.userStore = new HashMap<>();
        userStore.put("user1", "password1");
        userStore.put("user2", "password2");
    }

    public String getPassword(String username) {
        return userStore.get(username);
    }

    public boolean isValidUser(String username, String password) {
        String storedPassword = userStore.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}

public class AuthFailure {

    private SessionManager sessionManager;

    public java_12415_SessionManager_A07() {
        this.sessionManager = new SessionManager();
    }

    public boolean attemptAuth(String username, String password) {
        return sessionManager.isValidUser(username, password);
    }
}