import java.util.ArrayList;
import java.util.List;

public class java_35717_SessionManager_A01 {

    private List<String> authenticatedUsers;
    private List<String> authorizedActions;

    public java_35717_SessionManager_A01() {
        this.authenticatedUsers = new ArrayList<>();
        this.authorizedActions = new ArrayList<>();
    }

    public void authenticate(String username) {
        // Assume we have a database for authentication.
        // For brevity, this is just a simple check.
        if (username.equals("admin")) {
            this.authenticatedUsers.add(username);
        } else {
            throw new SecurityException("Unauthorized user.");
        }
    }

    public void authorize(String action) {
        // Assume we have a database for authorization.
        // For brevity, this is just a simple check.
        if (action.equals("read")) {
            this.authorizedActions.add(action);
        } else {
            throw new SecurityException("Unauthorized action.");
        }
    }

    public void checkAccess() {
        for (String user : this.authenticatedUsers) {
            for (String action : this.authorizedActions) {
                System.out.println(user + " is authorized to " + action);
            }
        }
    }
}