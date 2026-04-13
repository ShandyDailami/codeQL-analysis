import java.util.ArrayList;
import java.util.List;

public class java_38039_SessionManager_A03 {

    private static List<String> validUsers = new ArrayList<>();

    static {
        validUsers.add("admin");
        validUsers.add("user");
    }

    public static boolean isValidUser(String user) {
        if (user == null || user.isEmpty()) {
            return false;
        }
        return validUsers.contains(user);
    }

    public static void main(String[] args) {
        // Try to login with valid and invalid users
        System.out.println("Is 'admin' valid? " + isValidUser("admin"));
        System.out.println("Is '' valid? " + isValidUser(""));
        System.out.println("Is 'nonexistentuser' valid? " + isValidUser("nonexistentuser"));
    }
}