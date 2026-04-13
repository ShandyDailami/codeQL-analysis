import java.util.HashMap;
import java.util.Map;

public class java_41747_SessionManager_A01 {
    private Map<String, String> database;

    public java_41747_SessionManager_A01() {
        database = new HashMap<>();
        database.put("admin", "password"); // This should not be hardcoded into your application. You should store passwords securely.
    }

    public String getPassword(String username) {
        return database.get(username);
    }

    public boolean authenticate(String username, String password) {
        String passwordFromDatabase = database.get(username);
        return passwordFromDatabase != null && passwordFromDatabase.equals(password);
    }

    public Session createSession(String username) {
        if (!authenticate(username, "password")) { // In a real application, you would probably want to return null or throw an exception.
            throw new SecurityException("Invalid username or password");
        }
        return new Session(username);
    }

    public static class Session {
        private String username;

        public java_41747_SessionManager_A01(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }
}