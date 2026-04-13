import java.util.ArrayList;
import java.util.List;

public class java_28373_SessionManager_A08 {

    // List to store users
    private List<User> users;

    // Initializing the list of users
    public java_28373_SessionManager_A08() {
        users = new ArrayList<>();
    }

    // Method to add user
    public void addUser(User user) {
        users.add(user);
    }

    // Method to remove user
    public void removeUser(User user) {
        users.remove(user);
    }

    // Method to check if a user is in the list
    public boolean hasUser(User user) {
        return users.contains(user);
    }

    // Class User is a simple POJO
    public class User {
        private String username;
        private String password;

        public java_28373_SessionManager_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof User)) {
                return false;
            }

            User user = (User) obj;

            return user.getUsername().equals(username) && user.getPassword().equals(password);
        }
    }
}