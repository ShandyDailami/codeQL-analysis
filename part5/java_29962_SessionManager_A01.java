import java.util.HashMap;
import java.util.Map;

public class java_29962_SessionManager_A01 {
    private Map<String, String> userPasswords;
    private Map<String, String> userRoles;

    public java_29962_SessionManager_A01() {
        userPasswords = new HashMap<>();
        userRoles = new HashMap<>();
    }

    public void addUser(String username, String password, String role) {
        userPasswords.put(username, password);
        userRoles.put(username, role);
    }

    public boolean isUserLoggedIn(String username, String password) {
        if (userPasswords.containsKey(username) && userPasswords.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPermission(String username, String permission) {
        if (userRoles.containsKey(username) && userRoles.get(username).equals(permission)) {
            return true;
        } else {
            return false;
        }
    }
}