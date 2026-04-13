import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;

public class java_37473_SessionManager_A01 {
    private List<String> loggedInUsers;

    public java_37473_SessionManager_A01() {
        loggedInUsers = new ArrayList<>();
    }

    public boolean login(String user, String password) {
        // This is a placeholder for a secure login system. Replace with actual logic.
        if (user.equals("admin") && password.equals("password")) {
            loggedInUsers.add(user);
            return true;
        } else {
            throw new RuntimeErrorException(null, "Invalid credentials!");
        }
    }

    public void logout(String user) {
        loggedInUsers.remove(user);
    }

    public boolean isLoggedIn(String user) {
        return loggedInUsers.contains(user);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        if (securityManager.login("admin", "password")) {
            System.out.println("Logged in successfully!");

            if (securityManager.isLoggedIn("admin")) {
                System.out.println("Admin is logged in.");
            } else {
                System.out.println("Admin is not logged in.");
            }

            securityManager.logout("admin");
            System.out.println("Logged out successfully!");
        } else {
            System.out.println("Failed to login.");
        }
    }
}