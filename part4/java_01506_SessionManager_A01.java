import java.util.ArrayList;

public class java_01506_SessionManager_A01 {
    private ArrayList<User> users;

    public java_01506_SessionManager_A01() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean checkAccess(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser(new User("user1", "pass1"));
        sessionManager.addUser(new User("user2", "pass2"));

        boolean accessGranted = sessionManager.checkAccess("user1", "pass1");
        if (accessGranted) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}