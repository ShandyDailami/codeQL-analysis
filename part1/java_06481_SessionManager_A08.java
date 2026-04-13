import java.util.HashMap;
import java.util.Map;

public class java_06481_SessionManager_A08 {
    private Map<String, String> userMap = new HashMap<>();

    // Method to allow user to login
    public void login(String username, String password) {
        if (checkCredentials(username, password)) {
            System.out.println("Login successful!");
            // start session for user
        } else {
            System.out.println("Login failed!");
        }
    }

    // Method to check credentials
    private boolean checkCredentials(String username, String password) {
        // hardcoded for the purpose of this example
        return username.equals("admin") && password.equals("password");
    }

    // Method to allow user to access restricted content
    public void accessRestrictedContent(String user) {
        if (isAuthorized(user)) {
            System.out.println("Accessing restricted content!");
            // perform actions on restricted content
        } else {
            System.out.println("Unauthorized access!");
        }
    }

    // Method to check if user is authorized to access restricted content
    private boolean isAuthorized(String user) {
        return userMap.containsKey(user) && userMap.get(user).equals("admin");
    }

    // Method to logout a user
    public void logout(String user) {
        userMap.remove(user);
        System.out.println("Logout successful!");
    }
}