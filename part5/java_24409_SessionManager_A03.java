import java.util.HashMap;
import java.util.Map;

public class java_24409_SessionManager_A03 {
    private Map<String, String> userMap;

    public java_24409_SessionManager_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1"); // Add your users here
    }

    public String getPassword(String user) {
        return userMap.get(user);
    }

    public boolean authenticate(String user, String password) {
        if (userMap.containsKey(user)) {
            return userMap.get(user).equals(password);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        boolean isAuthenticated = sessionManager.authenticate("user1", "password1");

        if (isAuthenticated) {
            System.out.println("User is authenticated");
        } else {
            System.out.println("User is not authenticated");
        }
    }
}