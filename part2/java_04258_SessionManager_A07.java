import java.util.ArrayList;
import java.util.List;

public class java_04258_SessionManager_A07 {

    private static List<String> loggedUsers;

    static {
        loggedUsers = new ArrayList<>();
    }

    public void login(String user) {
        if (loggedUsers.contains(user)) {
            System.out.println("User already logged in");
            return;
        }
        loggedUsers.add(user);
        System.out.println("User logged in");
    }

    public void logout(String user) {
        if (!loggedUsers.contains(user)) {
            System.out.println("User not logged in");
            return;
        }
        loggedUsers.remove(user);
        System.out.println("User logged out");
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.login("user1");
        sm.login("user2");
        sm.login("user1");
        sm.logout("user1");
        sm.logout("user3");
    }
}