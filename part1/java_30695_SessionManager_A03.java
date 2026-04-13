import java.util.HashMap;

public class java_30695_SessionManager_A03 {
    private HashMap<String, String> userMap;
    private HashMap<String, String> passwordMap;
    private HashMap<String, String> sessionMap;

    public java_30695_SessionManager_A03() {
        userMap = new HashMap<>();
        passwordMap = new HashMap<>();
        sessionMap = new HashMap<>();

        // Adding some users for testing
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");

        // Adding some passwords for testing
        passwordMap.put("password1", "user1");
        passwordMap.put("password2", "user2");
        passwordMap.put("password3", "user3");
    }

    public String login(String user, String password) {
        if (userMap.containsKey(user) && passwordMap.get(user).equals(password)) {
            String session = sessionMap.size() + "";
            sessionMap.put(session, user);
            return session;
        } else {
            return "Invalid user or password";
        }
    }

    public String getUser(String session) {
        if (sessionMap.containsKey(session)) {
            return sessionMap.get(session);
        } else {
            return "Invalid session";
        }
    }
}