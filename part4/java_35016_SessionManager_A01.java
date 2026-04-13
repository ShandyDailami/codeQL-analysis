import javax.security.auth.Subject;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_35016_SessionManager_A01 {

    private static List<Principal> authenticatedUsers;
    private static SessionManager instance;

    private java_35016_SessionManager_A01() {
        authenticatedUsers = new ArrayList<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void login(String username, String password) {
        // Here, we're just checking if the username exists in our list of authenticated users.
        // In a real application, you'd want to hash the password and compare it to the stored hash.
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };

        authenticatedUsers.add(principal);
    }

    public void logout(String username) {
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };

        authenticatedUsers.remove(principal);
    }

    public boolean isUserAuthenticated(String username) {
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return username;
            }
        };

        return authenticatedUsers.contains(principal);
    }
}