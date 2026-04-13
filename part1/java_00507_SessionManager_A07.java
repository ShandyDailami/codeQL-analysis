import java.util.HashSet;
import java.util.Set;

public class java_00507_SessionManager_A07 {
    private Set<String> loggedUsers;
    private Set<String> authorizedUsers;

    public java_00507_SessionManager_A07() {
        this.loggedUsers = new HashSet<>();
        this.authorizedUsers = new HashSet<>();
    }

    public void login(String user) {
        // Secure operation: Log the user in
        this.loggedUsers.add(user);
        System.out.println("User " + user + " logged in.");
    }

    public void authorize(String user) {
        // Secure operation: Authorize the user
        this.authorizedUsers.add(user);
        System.out.println("User " + user + " authorized.");
    }

    public boolean isAuthorized(String user) {
        // Secure operation: Check if the user is authorized
        return this.authorizedUsers.contains(user);
    }

    public boolean isLoggedIn(String user) {
        // Secure operation: Check if the user is logged in
        return this.loggedUsers.contains(user);
    }

    public void logout(String user) {
        // Secure operation: Log the user out
        this.loggedUsers.remove(user);
        System.out.println("User " + user + " logged out.");
    }
}