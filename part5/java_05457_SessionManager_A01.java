import java.util.HashMap;
import java.util.Map;

public class java_05457_SessionManager_A01 {

    private Map<String, String> userMap;
    private Map<String, String> passwordMap;

    public java_05457_SessionManager_A01() {
        userMap = new HashMap<>();
        passwordMap = new HashMap<>();
    }

    public boolean login(String username, String password) {
        if (userMap.containsKey(username) && passwordMap.containsKey(username)) {
            if (passwordMap.get(username).equals(password)) {
                System.out.println("User " + username + " logged in successfully.");
                return true;
            } else {
                System.out.println("Incorrect password for user " + username + ".");
                return false;
           
            }
        } else {
            System.out.println("User " + username + " not found.");
            return false;
        }
    }

    public void logout(String username) {
        if (userMap.containsKey(username)) {
            System.out.println("User " + username + " logged out successfully.");
        } else {
            System.out.println("User " + username + " not found.");
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        manager.userMap.put("user1", "password1");
        manager.passwordMap.put("user1", "password1");

        manager.login("user1", "password1");

        manager.logout("user1");
    }
}