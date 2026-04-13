import java.util.HashMap;

public class java_07329_SessionManager_A07 {
    // Username and password storage
    private HashMap<String, String> userCredentials = new HashMap<>();

    // User storage
    private HashMap<String, User> loggedInUsers = new HashMap<>();

    // User class
    public class User {
        public String username;
        public String password;

        public java_07329_SessionManager_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Login method
    public boolean login(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            loggedInUsers.put(username, new User(username, password));
            return true;
        } else {
            return false;
        }
    }

    // Logout method
    public boolean logout(String username) {
        if (loggedInUsers.containsKey(username)) {
            loggedInUsers.remove(username);
            return true;
        } else {
            return false;
        }
    }

    // AuthFailure method
    public boolean authFailure(String oldUsername, String newUsername) {
        if (loggedInUsers.containsKey(oldUsername)) {
            if (userCredentials.containsKey(newUsername) && !userCredentials.get(newUsername).equals(loggedInUsers.get(oldUsername).password)) {
                User user = loggedInUsers.get(oldUsername);
                user.password = user.password + newUsername;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}