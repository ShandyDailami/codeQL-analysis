import java.util.*;

public class java_02825_SessionManager_A01 {
    // The user list is used to simulate the real world situation where a list of users is maintained
    private List<User> userList = new ArrayList<>();

    // User class is used to simulate a user in the real world
    public class User {
        public String name;
        public boolean isActive;

        public java_02825_SessionManager_A01(String name) {
            this.name = name;
        }
    }

    // Method to add a user
    public void addUser(String name) {
        userList.add(new User(name));
    }

    // Method to remove a user
    public void removeUser(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.name.equals(name)) {
                iterator.remove();
            }
        }
    }

    // Method to check if a user is active
    public boolean isUserActive(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.name.equals(name) && user.isActive) {
                return true;
            }
        }
        return false;
    }

    // Method to block a user
    public void blockUser(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.name.equals(name)) {
                user.isActive = false;
            }
        }
    }

    // Method to unblock a user
    public void unblockUser(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.name.equals(name)) {
                user.isActive = true;
            }
        }
    }
}