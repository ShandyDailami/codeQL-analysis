import java.util.HashMap;
import java.util.Map;

public class java_28152_SessionManager_A01 {

    private Map<String, String> credentials;

    public java_28152_SessionManager_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean isValid(String username, String password) {
        String correctPassword = this.credentials.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }
}

public class SessionManager {

    private SecurityManager securityManager;

    public java_28152_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public boolean isLoggedIn(String username, String password) {
        return this.securityManager.isValid(username, password);
    }
}