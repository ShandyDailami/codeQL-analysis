import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import java.util.HashMap;
import java.util.Map;

public class java_08665_SessionManager_A08 {

    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_08665_SessionManager_A08() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        if (userMap.containsKey(username)) {
            throw new FailedLoginException("User already exists");
        } else {
            userMap.put(username, password);
        }
    }

    public void login(String username, String password) throws LoginException {
        if (!userMap.containsKey(username)) {
            throw new LoginException("User does not exist");
        } else if (!userMap.get(username).equals(password)) {
            throw new FailedLoginException("Password incorrect");
        }
        sessionMap.put(username, password);
    }

    public void logout(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
        } else {
            throw new FailedLoginException("User is not logged in");
        }
    }
}