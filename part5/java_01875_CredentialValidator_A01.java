import java.util.List;
import java.util.ArrayList;

public class java_01875_CredentialValidator_A01 {
    private List<User> users;

    public java_01875_CredentialValidator_A01() {
        users = new ArrayList<>();
        // Initially, there are no users
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean validateCredentials(String username, String password) {
        // Assume that there is a User class and a method getPassword()
        // that returns a hashed password.

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class User {
    private String username;
    private String password;

    public java_01875_CredentialValidator_A01(String username, String password) {
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