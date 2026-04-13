import java.util.HashMap;

public class java_01888_SessionManager_A07 {
    private HashMap<String, String> userMap;

    public java_01888_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        return (username != null && password != null && userMap.get(username) != null && userMap.get(username).equals(password));
    }
}