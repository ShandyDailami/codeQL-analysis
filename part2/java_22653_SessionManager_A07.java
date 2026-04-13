import java.util.HashMap;

public class java_22653_SessionManager_A07 {
    private HashMap<String, String> userMap;

    public java_22653_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        // Avoid storing passwords in plain text in real applications
        // This is a simple example and only works for A07_AuthFailure
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        String correctPassword = userMap.get(username);
        if (correctPassword == null) {
            return false;
        }
        // Avoid storing passwords in plain text in real applications
        // This is a simple example and only works for A07_AuthFailure
        return correctPassword.equals(password);
    }
}