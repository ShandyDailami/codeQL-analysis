import java.util.HashMap;
import java.util.Map;

public class java_27044_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_27044_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void secureOperation(String username) throws AuthFailureException {
        if (authenticate(username, "password")) {
            System.out.println("Access granted to secure operation!");
        } else {
            throw new AuthFailureException("Authentication failed!");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser("user1", "password");

        try {
            sessionManager.secureOperation("user1");
        } catch (AuthFailureException e) {
            e.printStackTrace();
        }
    }
}