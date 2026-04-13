import java.util.HashMap;
import java.util.Map;

public class java_38774_SessionManager_A07 {
    private Map<String, String> database;

    public java_38774_SessionManager_A07() {
        this.database = new HashMap<>();
        this.database.put("user1", "password1");
        this.database.put("user2", "password2");
        this.database.put("user3", "password3");
    }

    public boolean authenticate(String user, String password) {
        String expectedPassword = this.database.get(user);
        if (expectedPassword == null) {
            return false;
        } else if (expectedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserName(String sessionId) {
        return this.database.get(sessionId);
    }

    public void invalidate(String sessionId) {
        this.database.remove(sessionId);
    }
}