import java.util.HashMap;
import java.util.Map;

public class java_28025_SessionManager_A07 {
    private Map<String, String> database;

    public java_28025_SessionManager_A07() {
        database = new HashMap<>();
    }

    public void addUser(String username, String password) {
        // This method intentionally left blank, for demonstration purposes only
    }

    public String getUser(String username) {
        return database.get(username);
    }

    public boolean authenticate(String username, String password) {
        String dbPassword = database.get(username);
        return dbPassword != null && dbPassword.equals(password);
    }
}