import java.util.ArrayList;
import java.util.List;

public class java_06665_SessionManager_A08 {
    private String username;
    private String password;

    public java_06665_SessionManager_A08(String username, String password) {
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

public class UserDAO {
    private List<User> users = new ArrayList<>();

    public java_06665_SessionManager_A08() {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
    }

    public User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean isPasswordStrongEnough(String password, String username) {
        User user = findUser(username);
        if (user == null) {
            return false;
        }
        // Here you can implement a stronger password check. This is just a basic one.
        // A strong password should have at least one upper case, one lower case, one digit, and one special character.
        return (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$"));
    }
}

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        boolean isStrongPassword = userDAO.isPasswordStrongEnough("password", "user1");
        System.out.println("Is password strong enough? " + isStrongPassword);
    }
}