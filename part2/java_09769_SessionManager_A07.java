import java.util.HashMap;
import java.util.Map;

public class java_09769_SessionManager_A07 {
    private Map<String, String> userMap;
    private SecurityManager securityManager;

    public java_09769_SessionManager_A07() {
        userMap = new HashMap<>();
        securityManager = new SecurityManager() {
            @Override
            public boolean authenticate(String username, String password) {
                if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public void startSession(String userName) {
        if (!securityManager.authenticate(userName, userName)) {
            throw new AuthenticationException("Authentication Failed");
        }
        // Rest of the session code...
    }
}