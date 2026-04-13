import java.util.HashMap;
import java.util.Map;

public class java_15558_SessionManager_A01 {
    private Map<String, String> users;

    public java_15558_SessionManager_A01() {
        users = new HashMap<>();
        users.put("admin", "password");
    }

    public boolean authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void secureOperation(String operation, String password) {
        if (authenticate(operation, password)) {
            System.out.println("Access granted for operation: " + operation);
        } else {
            System.out.println("Access denied for operation: " + operation);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();

        // You should not be able to access this operation if you do not authenticate.
        manager.secureOperation("accessDeniedOperation", "wrongPassword");

        // Now you should be able to access this operation if you have the right password.
        manager.secureOperation("accessGrantedOperation", "correctPassword");
    }
}