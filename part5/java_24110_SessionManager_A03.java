import java.util.*;

public class java_24110_SessionManager_A03 {

    private static Map<String, String> sessionMap = new HashMap<>();

    public static void main(String[] args) {
        addSession("username1", "session1");
        addSession("username2", "session2");
        addSession("username3", "session3");

        // Login
        if(login("username1", "session1")) {
            System.out.println("Welcome back, user1");
        } else {
            System.out.println("Login failed for user1");
        }

        // Logout
        logout("username1");

        if(!login("username1", "session1")) {
            System.out.println("Successfully logged out, user1");
        } else {
            System.out.println("Failed to log out, user1");
        }

        // Adding new user
        addSession("username4", "session4");

        if(login("username4", "session4")) {
            System.out.println("Welcome back, user4");
        } else {
            System.out.println("Failed to log in, user4");
        }

    }

    public static boolean login(String username, String session) {
        if(sessionMap.containsKey(username) && sessionMap.get(username).equals(session)) {
            return true;
        } else {
            return false;
        }
    }

    public static void logout(String username) {
        sessionMap.remove(username);
    }

    public static void addSession(String username, String session) {
        sessionMap.put(username, session);
    }
}