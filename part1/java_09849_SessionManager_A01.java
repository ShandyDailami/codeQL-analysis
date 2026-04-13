import java.util.ArrayList;
import java.util.List;

public class java_09849_SessionManager_A01 {

    private List<String> authorizedUsers;

    public java_09849_SessionManager_A01() {
        authorizedUsers = new ArrayList<>();
    }

    public void addAuthorizedUser(String user) {
        authorizedUsers.add(user);
    }

    public void removeAuthorizedUser(String user) {
        authorizedUsers.remove(user);
    }

    public boolean isAuthorizedUser(String user) {
        return authorizedUsers.contains(user);
    }

    public void sessionStart(String user) {
        if (!isAuthorizedUser(user)) {
            System.out.println("Access denied for user: " + user);
            return;
        }

        System.out.println("Access granted for user: " + user);
    }

    public void sessionEnd(String user) {
        System.out.println("Session ended for user: " + user);
    }
}