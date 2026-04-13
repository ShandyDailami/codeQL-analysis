import java.util.HashSet;
import java.util.Set;

public class java_13160_SessionManager_A07 {
    private static final Set<String> loggedUsers = new HashSet<>();

    public void login(String user) {
        if (loggedUsers.contains(user)) {
            throw new AuthFailureException("Already logged in as user: " + user);
        } else {
            loggedUsers.add(user);
        }
    }

    public void logout(String user) {
        if (!loggedUsers.contains(user)) {
            throw new AuthFailureException("Not logged in as user: " + user);
        } else {
            loggedUsers.remove(user);
        }
    }

    public boolean isLoggedIn(String user) {
        return loggedUsers.contains(user);
    }
}