import java.util.HashMap;
import java.util.Map;

public class java_02359_SessionManager_A08 {
    private Map<String, String> userDatabase;

    public java_02359_SessionManager_A08() {
        userDatabase = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userDatabase.put(username, password);
    }

    public String getPassword(String username) {
        return userDatabase.get(username);
    }

    public boolean isValidUser(String username, String password) {
        String dbPassword = getPassword(username);
        return dbPassword != null && dbPassword.equals(password);
    }

    public void startSession(String username) {
        if (!isValidUser(username, "password")) {
            throw new SecurityException("Invalid username or password");
        }
        // Session is started.
    }

    public void endSession(String username) {
        // Session is ended.
    }
}