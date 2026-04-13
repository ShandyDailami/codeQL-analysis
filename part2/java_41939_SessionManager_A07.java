import java.sql.*;
import java.util.*;

public class java_41939_SessionManager_A07 {
    private static Map<String, String> userMap;
    private static Map<String, String> passwordMap;
    private static List<String> sessionList;

    static {
        userMap = new HashMap<>();
        passwordMap = new HashMap<>();
        sessionList = new ArrayList<>();

        //Add dummy users for testing purposes
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        passwordMap.put("password1", "user1");
        passwordMap.put("password2", "user2");
    }

    public static boolean authenticate(String user, String password) {
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
            sessionList.add(user);
            return true;
        } else {
            return false;
        }
    }

    public static void logout(String user) {
        sessionList.remove(user);
    }

    public static boolean checkSession(String user) {
        return sessionList.contains(user);
    }
}