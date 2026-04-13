import java.util.HashMap;
import java.util.Map;

public class java_02166_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_02166_SessionManager_A01() {
        this.userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean checkCredentials(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_02166_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean login(String username, String password) {
        if (securityManager.checkCredentials(username, password)) {
            return true;
        } else {
            return false;
        }
    }
}