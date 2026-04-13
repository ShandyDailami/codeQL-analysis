import java.util.ArrayList;
import java.util.List;

public class java_02460_SessionManager_A03 {

    private UserDao userDao;
    private List<User> activeUsers;

    public java_02460_SessionManager_A03(UserDao userDao) {
        this.userDao = userDao;
        activeUsers = new ArrayList<>();
    }

    public User findUser(String username, String password) {
        // Simulate security sensitive operation
        if(isPasswordCorrect(username, password)) {
            return userDao.findUser(username);
        } else {
            throw new SecurityException("Invalid username or password");
        }
    }

    private boolean isPasswordCorrect(String username, String password) {
        // Simulate password checking. Replace this with actual logic
        return username.equals("admin") && password.equals("password");
    }

    public void addUser(User user) {
        // Simulate security sensitive operation
        if(isUserActive(user)) {
            userDao.addUser(user);
            activeUsers.add(user);
        } else {
            throw new SecurityException("User is already active");
        }
    }

    private boolean isUserActive(User user) {
        // Simulate user status checking. Replace this with actual logic
        return !activeUsers.contains(user);
    }
}