import java.util.HashMap;
import java.util.Map;

public class java_25484_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_25484_SessionManager_A01() {
        this.userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean isValidUser(String username, String password) {
        String expectedPassword = userMap.get(username);

        if (expectedPassword == null) {
            System.out.println("Invalid username");
            return false;
        }

        if (!expectedPassword.equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        securityManager.addUser("user1", "password1");
        securityManager.addUser("user2", "password2");

        boolean isValidUser1 = securityManager.isValidUser("user1", "password1");
        boolean isValidUser2 = securityManager.isValidUser("user2", "wrongPassword");
        boolean isValidUser3 = securityManager.isValidUser("unknownUser", "password");

        System.out.println("User1 is valid: " + isValidUser1);
        System.out.println("User2 is valid: " + isValidUser2);
        System.out.println("User3 is valid: " + isValidUser3);
    }
}