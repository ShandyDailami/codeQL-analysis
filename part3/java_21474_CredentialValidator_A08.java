import java.util.ArrayList;
import java.util.List;

public class java_21474_CredentialValidator_A08 {
    // Store users and their passwords
    private List<User> users = new ArrayList<>();

    // Initialize the users
    public java_21474_CredentialValidator_A08() {
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
    }

    // Validate the credentials
    public boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // User class
    public class User {
        private String username;
        private String password;

        public java_21474_CredentialValidator_A08(String username, String password) {
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
}