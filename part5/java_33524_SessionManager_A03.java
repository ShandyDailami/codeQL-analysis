import java.util.ArrayList;
import java.util.List;

public class java_33524_SessionManager_A03 {

    private List<User> users;
    private List<String> sessions;
    private int sessionCount;

    public java_33524_SessionManager_A03() {
        users = new ArrayList<>();
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                // Create a new session and add it to the list
                String sessionID = "session" + sessionCount;
                sessions.add(sessionID);
                sessionCount++;
                return user;
            }
        }
        return null; // return null if user not found
    }

    public User getUserBySession(String sessionID) {
        // Find the user by sessionID in the list of sessions
        for (User user : users) {
            for (String session : sessions) {
                if (session.equals(sessionID)) {
                    return user;
                }
            }
        }
        return null; // return null if session not found
    }
}

class User {
    private String username;
    private String password;

    public java_33524_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}